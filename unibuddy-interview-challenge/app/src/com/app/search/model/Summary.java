package com.app.search.model;

public class Summary {
    private String summaryText;
    private int id;

    public Summary(String summaryText, int id) {
        this.summaryText = summaryText;
        this.id = id;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public int getId() {
        return id;
    }
}
