package com.rosolowski.news.Views;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rosolowski.news.Adapters.ArticleAdapter;
import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Data.Section;
import com.rosolowski.news.R;
import com.rosolowski.news.Services.ArticleLoader;

import java.util.ArrayList;
import java.util.List;

public class ArticlesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>> {

    private static final int ARTICLES_LOADER_ID = 1;
    public static final String LOG_TAG = ArticlesActivity.class.getName();
    private Section selectedSection = Section.FOOTBALL; // TODO: change to all

    private ArticleAdapter mAdapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_activity);

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);

        mAdapter = new ArticleAdapter(
                this, new ArrayList<Article>());
        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Article currentArticle = mAdapter.getItem(position);
//                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
//                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
//                startActivity(websiteIntent);

                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

//                String minMagnitude = sharedPrefs.getString(
//                        getString(R.string.settings_min_magnitude_key),
//                        getString(R.string.settings_min_magnitude_default));

//                Log.d(LOG_TAG, minMagnitude);
                Log.d(LOG_TAG, String.valueOf(currentArticle));
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLES_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

    }

    // Loader

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> earthquakes) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_articles);

        mAdapter.clear();

        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        mAdapter.clear();
    }


    @Override
    public Loader<List<Article>> onCreateLoader(int id, Bundle args) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String selectedSectionString  = sharedPrefs.getString(
                getString(R.string.settings_section_by_key),
                getString(R.string.settings_section_by_default)
        );

        Section selectedSection = parseSectionId(selectedSectionString);

        return new ArticleLoader(this, selectedSection); // TODO: pass last selected section
    }

    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Section parseSectionId(String sectionId) {
        Section section = null;

        switch(sectionId)
        {
            case "football":
                section = Section.FOOTBALL;
                break;
            case "technology":
                section = Section.TECHNOLOGY;
                break;
            default:
                section = Section.ALL;
                break;
        }

        return section;
    }
}
