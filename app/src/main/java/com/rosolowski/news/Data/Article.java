package com.rosolowski.news.Data;

import androidx.annotation.NonNull;
import com.rosolowski.news.Utils.DateParser;
import java.util.Date;

public class Article {

    private String webTitle;
    private Date webPublicationDate;
    private String webUrl;

    public Article(String webTitle, Date webPublicationDate, String webUrl) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public Date getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getFormatedDate() {
        return DateParser.formatDate(webPublicationDate);
    }

    public String getWebUrl() {
        return webUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article - " + webTitle + "\n\tDate - " + DateParser.formatDate(webPublicationDate) + "\n\tUrl - " + webUrl;
    }
}
