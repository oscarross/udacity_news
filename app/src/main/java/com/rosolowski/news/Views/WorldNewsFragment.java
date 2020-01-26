package com.rosolowski.news.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.rosolowski.news.Adapters.ArticleAdapter;
import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Data.DatabaseStore;
import com.rosolowski.news.R;

import java.util.ArrayList;

public class WorldNewsFragment extends Fragment {

    private DatabaseStore store;

    public WorldNewsFragment() {
        this.store = new DatabaseStore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_list, container, false);

        final ArrayList<Article> arrayList = store.getNewsForCategory(Article.Category.WORLD);
        ArticleAdapter newsAdapter = new ArticleAdapter(getActivity(), arrayList);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(newsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article news = arrayList.get(position);
                Log.v("Click", "News: " + news);
            }
        });

        return rootView;
    }

}
