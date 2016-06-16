package edu.projectuz.mCal.web.converter;

import edu.projectuz.mCal.helpers.DateHelper;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import java.util.TimeZone;

public final class StringToDateConverter
        implements Converter<String, DateTime> {

    private String dateFormat = "dd-MM-yyyy HH:mm:ss";
    private TimeZone defaultTimeZone = TimeZone.getTimeZone("Europe/Warsaw");

    @Override
    public DateTime convert(final String date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return DateHelper.stringToDate(date, dateFormat, defaultTimeZone);
    }
}
