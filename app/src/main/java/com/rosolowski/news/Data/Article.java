package com.rosolowski.news.Data;

import androidx.annotation.NonNull;
import com.rosolowski.news.Utils.DateParser;
import java.util.Date;

public class Article {

    private String webTitle;
    private Date webPublicationDate;
    private String webUrl;
    private String sectionId;
    private String sectionName;

    public Article(String webTitle, Date webPublicationDate, String webUrl, String sectionId, String sectionName) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
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

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article - " + webTitle + "\n\tDate - " + DateParser.getYearMonthDayString(webPublicationDate) + "\n\tTime - " + DateParser.getTimeString(webPublicationDate) + "\n\tUrl - " + webUrl;
    }


}
