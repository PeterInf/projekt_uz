package edu.projectuz.mCal.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Methods which help with date problems.
 */
public class DateHelper {

    /**
     * Simple helper for convert String to Date.
     * @param dateText provided date to convert
     * @param dateFormat date is formatted by specified parameter
     * @param timezone timezone to format date
     * @return formatted date from String
     */
    public static Date stringToDate(String dateText, String dateFormat, TimeZone timezone){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
       // format.setTimeZone(timezone);
        try {
            date = format.parse(dateText);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static TimeZone stringToTimeZone(String timeZoneInString) {
        return TimeZone.getTimeZone(timeZoneInString);
    }
}