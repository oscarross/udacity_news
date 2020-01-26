package com.rosolowski.news.Services;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Data.Section;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private Section section;

    public ArticleLoader(Context context, Section section) {
        super(context);

        this.section = section;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (section == null) {
            return null;
        }

        return ArticleService.fetchArticlesData(section);
    }
}