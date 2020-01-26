package com.rosolowski.news.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Data.Section;
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

        String sectiondId = currentArticle.getSectionId();

        TextView subtitleTextView = listView.findViewById(R.id.place_list_item_section);
        subtitleTextView.setText(currentArticle.getSectionName());
        subtitleTextView.setBackgroundColor(getSectionBackgroundColor(sectiondId));
        subtitleTextView.setTextColor(getSectionTextColor(sectiondId));

        TextView dateTextView = listView.findViewById(R.id.place_list_item_date);
        dateTextView.setText(currentArticle.getYearMonthDayString());

        TextView timeTextView = listView.findViewById(R.id.place_list_item_time);
        timeTextView.setText(currentArticle.getTimeString());

        return listView;
    }


    private int getSectionBackgroundColor(String sectionId) {
        int colorResourceId = R.color.colorAccent;

        if (sectionId.equals(Section.FOOTBALL.toString())) {
            colorResourceId = R.color.green;
        } else if (sectionId.equals(Section.TECHNOLOGY.toString())) {
            colorResourceId = R.color.blue;
        } else if (sectionId.equals(Section.POLITICS.toString())) {
            colorResourceId = R.color.yellow;
        }


        return ContextCompat.getColor(getContext(), colorResourceId);
    }

    private int getSectionTextColor(String sectionId) {
        int colorResourceId = R.color.black;

        if (sectionId.equals(Section.FOOTBALL.toString())) {
            colorResourceId = R.color.white;
        } else if (sectionId.equals(Section.TECHNOLOGY.toString())) {
            colorResourceId = R.color.white;
        } else if (sectionId.equals(Section.POLITICS.toString())) {
            colorResourceId = R.color.black;
        }


        return ContextCompat.getColor(getContext(), colorResourceId);
    }
}