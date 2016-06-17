package edu.projectuz.mCal.importers.ICal.model;

import edu.projectuz.mCal.importers.ical.model.ICalTimeZone;
import edu.projectuz.mCal.importers.ical.model.ICalTimeZoneProperty;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ICalTimeZoneTest {

    private String timeZoneId, timeZoneUrl, location;
    private ArrayList<ICalTimeZoneProperty> timeZones;
    private ICalTimeZone timeZone;

    @Before
    public void setUp(){
        timeZoneId = "1";
        timeZoneUrl = "www";
        location = "location";
        timeZones = new ArrayList<>();
        timeZone = new ICalTimeZone(timeZoneId, timeZoneUrl, location, timeZones);
    }

    @Test
    public void gettersTests(){
        assertNotNull(timeZone);
        assertEquals(timeZoneId, timeZone.getTimeZoneId());
        assertEquals(timeZoneUrl, timeZone.getTimeZoneUrl());
        assertEquals(location, timeZone.getLocation());
        assertEquals(timeZones, timeZone.getPropertyTimeZones());
    }

    @Test
    public void settersTests(){
        timeZone.setLocation(location);
        timeZone.setTimeZoneUrl(timeZoneUrl);
        timeZone.setPropertyTimeZones(timeZones);
        timeZone.setTimeZoneId(timeZoneId);
    }
}
