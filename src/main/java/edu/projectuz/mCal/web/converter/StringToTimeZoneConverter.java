package edu.projectuz.mCal.web.converter;

import edu.projectuz.mCal.helpers.DateHelper;
import org.springframework.core.convert.converter.Converter;

import java.util.TimeZone;

public class StringToTimeZoneConverter implements Converter<String, TimeZone> {

    @Override
    public final TimeZone convert(final String timeZone) {
        if (timeZone == null || timeZone.isEmpty()) {
            return null;
        }
        return DateHelper.stringToTimeZone(timeZone);
    }
}
