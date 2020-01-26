package com.rosolowski.news.Data;

public enum  Section {
    TECHNOLOGY("technology"),
    FOOTBALL("football"),
    ALL("all")
    ;

    private final String text;

    Section(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

