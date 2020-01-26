package com.rosolowski.news.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseDateStringWithTimeZoneToDate(String input) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date parsedDate = null;

        try {
            parsedDate = formatter.parse(input.replaceAll("Z$", "+0000"));
            System.out.println("Parsed date = " + formatter.format(parsedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }

    public static String getTimeString(Date input) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

        return formatter.format(input);
    }

    public static String getYearMonthDayString(Date input) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(input);
    }

}

