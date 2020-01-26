package com.rosolowski.news.Data;

import androidx.annotation.NonNull;

public class Article {

    public enum Category {
        WORLD, OTHER
    }

    private String webTitle;
    private String webPublicationDate;
    private Category category;
    private String webUrl;

    public Article(String webTitle, String webPublicationDate, Category category, String webUrl) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.category = category;
        this.webUrl = webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public Category getCategory() {
        return category;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article - " + webTitle + " Category - " + category;
    }
}
