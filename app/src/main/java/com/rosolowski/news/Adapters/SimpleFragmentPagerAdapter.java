package com.rosolowski.news.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Data.DatabaseStore;
import com.rosolowski.news.R;
import com.rosolowski.news.Views.OtherNewsFragment;
import com.rosolowski.news.Views.WorldNewsFragment;

import java.util.ArrayList;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Article.Category> categories;
    private Context context;

    public SimpleFragmentPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);

        this.context = context;
        this.categories = new DatabaseStore().getCategories();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Article.Category category = categories.get(position);

        switch (category) {
            case WORLD: return new WorldNewsFragment();
            case OTHER: return new OtherNewsFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Article.Category category = categories.get(position);

        switch (category) {
            case WORLD: return "WORLD";
            case OTHER: return "OTHER";
//            case WORLD: return context.getString(R.string.nature_category_title);
//            case OTHER: return context.getString(R.string.other_category_title);
        }

        return null;
    }
}