package com.app.search.preprocess;

import com.app.search.model.RelevantSummary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryCache {
    public static Map<String, List<RelevantSummary>> summaryMap = new HashMap<>();

    public static void printCache() {
        summaryMap.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " --> ");
        });
    }
}
