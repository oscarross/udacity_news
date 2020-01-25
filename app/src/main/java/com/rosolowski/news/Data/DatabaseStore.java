package com.rosolowski.news.Data;

import java.util.ArrayList;

public class DatabaseStore {
    public ArrayList<News.Category> getCategories() {
        final ArrayList<News.Category> categories = new ArrayList<>();

        categories.add(News.Category.WORLD);
        categories.add(News.Category.OTHER);

        return categories;
    }

    public ArrayList<News> getNewsForCategory(News.Category category) {
        switch (category) {
            case WORLD: return mockNewsWorld();
            case OTHER: return mockNewsOther();
        }

        return null;
    }

    private ArrayList<News> mockNewsWorld() {
        final ArrayList<News> array = new ArrayList<>();
        array.add(new News("News_1", News.Category.WORLD));
        array.add(new News("News_2", News.Category.WORLD));
        array.add(new News("News_3", News.Category.WORLD));
        array.add(new News("News_4", News.Category.WORLD));
        array.add(new News("News_5", News.Category.WORLD));
        array.add(new News("News_6", News.Category.WORLD));
        return array;
    }

    private ArrayList<News> mockNewsOther() {
        final ArrayList<News> array = new ArrayList<>();
        array.add(new News("News_1", News.Category.OTHER));
        array.add(new News("News_2", News.Category.OTHER));
        array.add(new News("News_3", News.Category.OTHER));
        array.add(new News("News_4", News.Category.OTHER));
        array.add(new News("News_5", News.Category.OTHER));
        array.add(new News("News_6", News.Category.OTHER));

        return array;
    }
}
