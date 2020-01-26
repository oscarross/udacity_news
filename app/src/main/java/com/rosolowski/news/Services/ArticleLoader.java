package com.rosolowski.news.Services;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.rosolowski.news.Data.Article;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private String mUrl;

    public ArticleLoader(Context context, String url) {
        super(context);

        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        return ArticleService.fetchArticlesData(mUrl);
    }
}