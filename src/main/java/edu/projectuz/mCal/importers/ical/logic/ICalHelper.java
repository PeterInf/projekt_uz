package edu.projectuz.mCal.importers.ical.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICalHelper {
    public static final Pattern regex = Pattern.compile("^(DTSTART|DTEND);TZID=(?<TIMEZONE>.+\\/.+)\\:(?<DATE>\\d{8})T(?<TIME>\\d{6})(\\\\r\\\\n)?$");

    private ICalHelper() {

    }

    public static String getGroupFromDate(
            String Date,
            final String groupName) {
        Date = Date.replaceAll("\\r\\n", "");
        Matcher matcher = regex.matcher(Date);
        if (matcher.matches()) {
            String dateTime = matcher.group(groupName);
            return dateTime;
        }
        return "";
    }
}
