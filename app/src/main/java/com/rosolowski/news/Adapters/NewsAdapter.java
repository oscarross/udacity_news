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

import com.rosolowski.news.Data.News;
import com.rosolowski.news.R;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> array) {
        super(context, 0, array);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleTextView = listView.findViewById(R.id.place_list_item_title);
        titleTextView.setText(currentNews.getName());

//        ImageView imageView = listView.findViewById(R.id.place_list_item_image);
//        imageView.setImageResource(currentPlace.getImageResourceId());

        return listView;
    }
}