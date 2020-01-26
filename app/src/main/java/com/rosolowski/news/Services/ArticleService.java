package com.rosolowski.news.Services;

import android.util.Log;

import com.rosolowski.news.Data.Article;
import com.rosolowski.news.Utils.DateParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleService {

    private static final String LOG_TAG = ArticleService.class.getName();

    private ArticleService() { }

    public static List<Article> fetchArticlesData(String requestUrl) {
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Article> articles = extractArticlesFromJson(jsonResponse);
        return articles;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the article JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static ArrayList<Article> extractArticlesFromJson(String jsonResponse) {
        ArrayList<Article> articles = new ArrayList<>();

        try {
            JSONObject baseJsonObject = new JSONObject(jsonResponse);
            JSONObject responseJsonObject = baseJsonObject.getJSONObject("response");
            JSONArray resultsJsonArray = responseJsonObject.getJSONArray("results");

            for (int i = 0; i < resultsJsonArray.length(); i++) {
                JSONObject currentArticleJsonObject = resultsJsonArray.getJSONObject(i);

                String webTitle = currentArticleJsonObject.getString("webTitle");
                String webPublicationDateString = currentArticleJsonObject.getString("webPublicationDate");
                Date webPublicationDate = DateParser.parseDateStringWithTimeZoneToDate(webPublicationDateString);
                String webUrl = currentArticleJsonObject.getString("webUrl");

                Article article = new Article(webTitle, webPublicationDate, webUrl);
                Log.d(LOG_TAG, String.valueOf(article));

                articles.add(article);
            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the article JSON", e);
        }

        return articles;
    }
}
