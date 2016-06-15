package edu.projectuz.mCal.core.models;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.SimpleTimeZone;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * It's a test class for class {@link CalendarEvent}.
 */
public class CalendarEventTest {

    private String title, description, tag;
    private DateTime startDate, endDate;
    private TimeZone timeZone;
    private CalendarEvent calendarEvent, sameCalendarEvent, emptyCalendarEvent;

    @Before
    public void setUp(){
        title = "title";
        description = "desc";
        tag = "tag";
        startDate = new DateTime();
        endDate = new DateTime();
        timeZone = new SimpleTimeZone(SimpleTimeZone.STANDARD_TIME, "Europe/Paris");
        calendarEvent = new CalendarEvent(title, startDate, endDate, description, tag, timeZone);
        sameCalendarEvent = new CalendarEvent(title, startDate, endDate, description, tag, timeZone);
        emptyCalendarEvent = new CalendarEvent();
    }

    /**
     * This method tested setters from {@link CalendarEvent} class.
     * Result should be positive.
     */
    @Test
    public void settersTests(){
        emptyCalendarEvent.setStartDate(startDate);
        emptyCalendarEvent.setEndDate(endDate);
    }

    /**
     * This method tested all getters from {@link CalendarEvent} class.
     * Result should be positive.
     */
    @Test
    public void gettersTests(){
        assertEquals(emptyCalendarEvent.getId(), calendarEvent.getId());
        assertEquals(timeZone.getID(), calendarEvent.getIdTimeZone());
        assertEquals(calendarEvent.toString(), sameCalendarEvent.toString());
        assertEquals(timeZone, calendarEvent.getTimeZone());
    }

    /**
     * This method tested equals and haschode method from {@link CalendarEvent} class.
     * Result should be positive.
     */
    @Test
    public void equalsAndHashCodeMethodsTests(){
        assertTrue(calendarEvent.equals(sameCalendarEvent) && sameCalendarEvent.equals(calendarEvent));
        assertFalse(calendarEvent.equals(emptyCalendarEvent));

        assertEquals(calendarEvent.hashCode(), sameCalendarEvent.hashCode());
        assertNotEquals(calendarEvent.hashCode(), emptyCalendarEvent.hashCode());
    }
}
