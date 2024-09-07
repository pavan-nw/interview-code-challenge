package com.app.search.model;

public class SearchInput {
    private String query;
    private int k;

    public SearchInput(String query, int k) {
        this.query = query;
        this.k = k;
    }

    public String getQuery() {
        return query;
    }

    public int getK() {
        return k;
    }
}
