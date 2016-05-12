package edu.projectuz.mCal.importers.ical.logic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sivik on 12-May-16.
 */
public class ICalHelper {
    public final static Pattern regex = Pattern.compile("^(DTSTART|DTEND);TZID=(?<timezone>.+\\/.+)\\:(?<date>\\d{8})T(?<time>\\d{6})(\\\\r\\\\n)?$");

    public  static String getGroupFromDate(String Date, String groupName){
        Date = Date.replaceAll("\\r\\n", "");
        Matcher matcher = regex.matcher(Date);
        if (matcher.matches()) {
            String dateTime = matcher.group(groupName);
            return dateTime;
        }
        return "";
    }
}
