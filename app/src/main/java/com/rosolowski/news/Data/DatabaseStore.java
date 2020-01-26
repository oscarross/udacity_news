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
        array.add(new Article("News_1", Article.Category.WORLD));
        array.add(new Article("News_2", Article.Category.WORLD));
        array.add(new Article("News_3", Article.Category.WORLD));
        array.add(new Article("News_4", Article.Category.WORLD));
        array.add(new Article("News_5", Article.Category.WORLD));
        array.add(new Article("News_6", Article.Category.WORLD));
        return array;
    }

    private ArrayList<Article> mockNewsOther() {
        final ArrayList<Article> array = new ArrayList<>();
        array.add(new Article("News_1", Article.Category.OTHER));
        array.add(new Article("News_2", Article.Category.OTHER));
        array.add(new Article("News_3", Article.Category.OTHER));
        array.add(new Article("News_4", Article.Category.OTHER));
        array.add(new Article("News_5", Article.Category.OTHER));
        array.add(new Article("News_6", Article.Category.OTHER));

        return array;
    }
}
