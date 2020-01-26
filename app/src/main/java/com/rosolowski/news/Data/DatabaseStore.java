package com.rosolowski.news.Data;

import java.util.ArrayList;

public class DatabaseStore {
    public ArrayList<Article.Category> getCategories() {
        final ArrayList<Article.Category> categories = new ArrayList<>();

        categories.add(Article.Category.WORLD);
        categories.add(Article.Category.OTHER);

        return categories;
    }

    public ArrayList<Article> getNewsForCategory(Article.Category category) {
        switch (category) {
            case WORLD: return mockNewsWorld();
            case OTHER: return mockNewsOther();
        }

        return null;
    }

    private ArrayList<Article> mockNewsWorld() {
        final ArrayList<Article> array = new ArrayList<>();
        array.add(new Article("News_1", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_2", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_3", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_4", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_5", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_6", "2020-01-26T09:06:18Z", Article.Category.WORLD, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        return array;
    }

    private ArrayList<Article> mockNewsOther() {
        final ArrayList<Article> array = new ArrayList<>();
        array.add(new Article("News_1", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_2", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_3", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_4", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_5", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));
        array.add(new Article("News_6", "2020-01-26T09:06:18Z", Article.Category.OTHER, "https://www.theguardian.com/environment/2020/jan/26/call-for-all-toiletries-to-carry-recycling-information"));

        return array;
    }
}
