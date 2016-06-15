package edu.projectuz.mCal.helpers;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

/**
 * Methods which help with date problems.
 */
public class DateHelper {

    /**
     * Simple helper for convert String to Date.
     * @param dateText   provided date to convert
     * @param dateFormat date is formatted by specified parameter
     * @return formatted date from String.
     */
    public static DateTime stringToDate(String dateText, String dateFormat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormat);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateText);
        return dateTime;
    }

    /**
     * Simple helper for convert String to Date.
     * @param dateText   provided date to convert
     * @param dateFormat date is formatted by specified parameter
     * @param timezone   timezone to format date
     * @return formatted date from String.
     */
    public static DateTime stringToDate(String dateText, String dateFormat, TimeZone timezone) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormat);
        DateTime dateTime = dateTimeFormatter.withZone(DateTimeZone.forTimeZone(timezone)).parseDateTime(dateText);
        return dateTime;
    }

    /**
     * Simple helper for convert String to timezone.
     * @param timeZoneInString timezone to format date
     * @return formatted timezone from String.
     */
    public static TimeZone stringToTimeZone(String timeZoneInString) {
        return TimeZone.getTimeZone(timeZoneInString);
    }
}