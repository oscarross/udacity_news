package com.rosolowski.news.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rosolowski.news.Data.Article;
import com.rosolowski.news.R;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArticleAdapter(Context context, ArrayList<Article> array) {
        super(context, 0, array);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        TextView titleTextView = listView.findViewById(R.id.place_list_item_title);
        titleTextView.setText(currentArticle.getWebTitle());

        TextView dateTextView = listView.findViewById(R.id.place_list_item_date);
        dateTextView.setText(currentArticle.getFormatedDate());

        return listView;
    }
}