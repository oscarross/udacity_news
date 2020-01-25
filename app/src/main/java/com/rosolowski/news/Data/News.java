package com.rosolowski.news.Data;

import androidx.annotation.NonNull;

public class News {

    public enum Category {
        WORLD, OTHER
    }

    private String name;
    private Category category;

    public News(String name, Category category) {
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
        return "News - " + name + " Category - " + category;
    }
}
