package com.rosolowski.news.Data;

import androidx.annotation.NonNull;
import com.rosolowski.news.Utils.DateParser;
import java.util.Date;

public class Article {

    private String webTitle;
    private Date webPublicationDate;
    private String webUrl;
    private Section section;

    public Article(String webTitle, Date webPublicationDate, String webUrl, Section section) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
        this.section = section;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getYearMonthDayString() {
        return DateParser.getYearMonthDayString(webPublicationDate);
    }

    public String getTimeString() {
        return DateParser.getTimeString(webPublicationDate);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public Section getSection() {
        return section;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article - " + webTitle + "\n\tDate - " + DateParser.getYearMonthDayString(webPublicationDate) + "\n\tTime - " + DateParser.getTimeString(webPublicationDate) + "\n\tUrl - " + webUrl;
    }


}
