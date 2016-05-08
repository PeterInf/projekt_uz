package edu.projectuz.mCal.helpers;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

/**
 * Methods which help with date problems.
 */
public final class DateHelper {

    private DateHelper(){

    }

    /**
     * Simple helper for convert String to Date.
     *
     * @param dateText   provided date to convert
     * @param dateFormat date is formatted by specified parameter
     * @param timezone   timezone to format date
     * @return formatted date from String
     */
    public static DateTime stringToDate(final String dateText,
                                        final String dateFormat, final TimeZone timezone) {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormat.forPattern(dateFormat);
        DateTime dateTime = dateTimeFormatter.withZone(DateTimeZone.
                forTimeZone(timezone)).parseDateTime(dateText);
        return dateTime;
    }

    public static TimeZone stringToTimeZone(final String timeZoneInString) {
        return TimeZone.getTimeZone(timeZoneInString);
    }
}
