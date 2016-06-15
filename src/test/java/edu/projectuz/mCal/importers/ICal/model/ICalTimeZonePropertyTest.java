package edu.projectuz.mCal.importers.ICal.model;

import edu.projectuz.mCal.importers.ical.model.ICalTimeZoneProperty;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ICalTimeZonePropertyTest {
    private String nameTimeZone, timeZoneOffsetFrom, timeZoneOffsetTo,
            timeZoneName, dateTimeStart, rule;
    private ICalTimeZoneProperty timeZone;

    @Before
    public void setUp(){
        nameTimeZone = "ntz";
        timeZoneOffsetFrom = "tzosf";
        timeZoneOffsetTo = "tzost";
        timeZoneName = "tzn";
        dateTimeStart  ="dts";
        rule = "rule";
        timeZone = new ICalTimeZoneProperty(nameTimeZone, timeZoneOffsetFrom, timeZoneOffsetTo,
                timeZoneName, dateTimeStart, rule);
    }

    @Test
    public void gettersTests(){
        assertNotNull(timeZone);
        assertEquals(nameTimeZone, timeZone.getNameTimeZone());
        assertEquals(timeZoneOffsetFrom, timeZone.getTimeZoneOffsetFrom());
        assertEquals(timeZoneOffsetTo, timeZone.getTimeZoneOffsetTo());
        assertEquals(timeZoneName, timeZone.getTimezoneName());
        assertEquals(dateTimeStart, timeZone.getDateTimeStart());
        assertEquals(rule, timeZone.getrRule());
    }

    @Test
    public void settersTests(){
        timeZone.setDateTimeStart(dateTimeStart);
        timeZone.setNameTimeZone(nameTimeZone);
        timeZone.setrRule(rule);
        timeZone.setTimeZoneOffsetFrom(timeZoneOffsetFrom);
        timeZone.setTimeZoneOffsetTo(timeZoneOffsetTo);
        timeZone.setTimezoneName(timeZoneName);
    }

}
