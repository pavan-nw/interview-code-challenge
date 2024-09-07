package com.app.search.preprocess;

import com.app.search.model.RelevantSummary;
import com.app.search.model.SearchInput;
import com.app.search.model.Summary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummaryCacheManager {

    public static void buildCache(List<Summary> summaryList) {
        List<String> words = summaryList.stream()
                .map(summary -> (List<String>) Arrays.asList(summary.getSummaryText().split(" ")))
                .collect(Collectors.toList())
                .stream().flatMap(Collection::stream).collect(Collectors.toList());

        words.forEach(w -> {
            summaryList.forEach(summary -> {
                List<RelevantSummary> list = SummaryCache.summaryMap.get(w);
                if(list == null) {
                    list = new ArrayList<RelevantSummary>();
                }
                list.add(buildRelavantSummary(w, summary));
                SummaryCache.summaryMap.put(w, list);
            });
        });
    }

    private static RelevantSummary buildRelavantSummary(String word, Summary summary) {
        int freq = (int) Arrays.stream(summary.getSummaryText().split(" "))
                .filter(s -> s.equals(word)).count();

        return new RelevantSummary(summary.getId(), freq);
    }

    public static List<RelevantSummary> search(SearchInput searchInput) {
        List<String> words = Arrays.asList(searchInput.getQuery().split(" "));
        Map<Integer, Integer> wordsMatched = new HashMap<>();
        List<RelevantSummary> relevantSummaries =  words.stream().map(
                w -> {
                    List<RelevantSummary> relavantSummaryList = SummaryCache.summaryMap.get(w);
                    relavantSummaryList.forEach(
                            s -> wordsMatched.put(s.getSummaryId(), wordsMatched.get(s.getSummaryId()+s.getFreq()))
                    );

                    return relavantSummaryList;
                }
        ).flatMap(Collection::stream).collect(Collectors.toList());

         return wordsMatched.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                 .limit(searchInput.getK())
                .map(e -> relevantSummaries
                        .stream()
                        .filter(relavantSummary -> relavantSummary.getSummaryId() == e.getKey())
                        .collect(Collectors.toList()))
                 .flatMap(Collection::stream)
                 .collect(Collectors.toList());
    }
}
