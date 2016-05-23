package edu.projectuz.mCal.web.converter;

import edu.projectuz.mCal.helpers.DateHelper;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import java.util.TimeZone;

public final class StringToDateConverter implements Converter<String, DateTime> {

    private String dateFormat = "dd-mm-yyyy HH:mm:ss";
    private TimeZone defaultTimeZone = TimeZone.getTimeZone("America/Los_Angeles");

    @Override
    public DateTime convert(String date) {
        if(date == null || date.isEmpty()) {
            return null;
        }
        return DateHelper.stringToDate(date, dateFormat, defaultTimeZone);
    }
}
