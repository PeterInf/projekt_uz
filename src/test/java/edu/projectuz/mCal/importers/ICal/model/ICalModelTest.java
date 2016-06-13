package edu.projectuz.mCal.importers.ICal.model;

import static org.junit.Assert.*;

import edu.projectuz.mCal.importers.ical.model.ICalEvent;
import edu.projectuz.mCal.importers.ical.model.ICalModel;
import edu.projectuz.mCal.importers.ical.model.ICalTimeZone;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ICalModelTest {

    private String version, prodId, calscale;
    private ArrayList<ICalTimeZone> timeZones;
    private ArrayList<ICalEvent> events;
    private ICalModel model;

    @Before
    public void setUp(){
        version = "1";
        prodId = "14";
        calscale = "calscale";
        timeZones = new ArrayList<>();
        events = new ArrayList<>();
        model = new ICalModel(version, prodId, calscale, timeZones, events);
    }

    @Test
    public void gettersTests(){
        assertNotNull(model);
        assertEquals(version, model.getVersion());
        assertEquals(prodId, model.getProdId());
        assertEquals(timeZones, model.getTimeZones());
        assertEquals(events, model.getEvents());
        assertEquals(calscale, model.getCalscale());
    }

    @Test
    public void settersTests(){
        ICalModel emptyModel = new ICalModel();
        emptyModel.setVersion(version);
        emptyModel.setCalscale(calscale);
        emptyModel.setProdId(prodId);
        emptyModel.setEvents(events);
        emptyModel.setTimeZones(timeZones);
    }

}
