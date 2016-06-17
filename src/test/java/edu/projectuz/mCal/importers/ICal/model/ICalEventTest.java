package edu.projectuz.mCal.importers.ICal.model;

import edu.projectuz.mCal.importers.ical.model.ICalEvent;
import edu.projectuz.mCal.importers.ical.model.ICalEventAlarm;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ICalEventTest {

    private String dateTimeStamp, uid, dateTimeStart, dateTimeEnd, summary, description;
    private ArrayList<ICalEventAlarm> eventAlarms;
    private ICalEvent event;

    @Before
    public void setUp(){
        dateTimeStamp = "dateTimeStamp";
        uid = "1";
        dateTimeStart = "dateTimeStart";
        dateTimeEnd = "dateTimeEnd";
        summary = "summary";
        description = "description";
        eventAlarms = new ArrayList<>();
        event = new ICalEvent(dateTimeStamp, uid, dateTimeStart, dateTimeEnd, summary, description, eventAlarms);
    }

    @Test
    public void gettersTests(){
        assertNotNull(event);
        assertEquals(dateTimeEnd, event.getDateTimeEnd());
        assertEquals(dateTimeStamp, event.getDateTimeStamp());
        assertEquals(dateTimeStart, event.getDateTimeStart());
        assertEquals(uid, event.getUid());
        assertEquals(summary, event.getSummary());
        assertEquals(description, event.getDescription());
        assertEquals(eventAlarms, event.getEventAlarms());
    }

    @Test
    public void settersTest(){
        event.setDescription(description);
        event.setDateTimeEnd(dateTimeEnd);
        event.setDateTimeStamp(dateTimeStamp);
        event.setDateTimeStart(dateTimeStart);
        event.setEventAlarms(eventAlarms);
        event.setSummary(summary);
        event.setUid(uid);
    }


}
