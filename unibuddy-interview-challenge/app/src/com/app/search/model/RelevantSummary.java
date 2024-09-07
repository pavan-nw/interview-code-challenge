package com.app.search.model;

public class RelevantSummary {

    private int summaryId;
    private int freq;

    public RelevantSummary(int summaryId, int freq) {
        this.summaryId = summaryId;
        this.freq = freq;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public int getFreq() {
        return freq;
    }
}
