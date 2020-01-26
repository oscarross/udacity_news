package com.rosolowski.news.Data;

import androidx.annotation.NonNull;

public class Article {

    public enum Category {
        WORLD, OTHER
    }

    private String name;
    private Category category;

    public Article(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article - " + name + " Category - " + category;
    }
}
