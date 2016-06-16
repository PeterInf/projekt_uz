package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TimetableDayTest {

    private TimetableDay timetableDay;

    @Before
    public void setUp() {
        timetableDay = new TimetableDay("Poniedziałek");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(timetableDay != null);
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("Poniedziałek", timetableDay.getName());
    }

    @Test
    public void whenAddEventThenHasSomeContent() {
        TimetableEvent timetableEvent = new TimetableEvent("A", "16:55", "18:25",
                "Programowanie współbieżne i rozproszone", "L",
                "dr inż. Tomasz Gratkowski", "207 A-2", "D/");

        assertTrue(timetableDay.getEventsList().isEmpty());
        timetableDay.addEvent(timetableEvent);
        assertFalse(timetableDay.getEventsList().isEmpty());
    }

    @Test
    public void whenSetListWithContentThenListNotEmpty() {
        ArrayList<TimetableEvent> timetableEvents = new ArrayList<>();
        TimetableEvent timetableEvent = new TimetableEvent("A", "16:55", "18:25",
                "Programowanie współbieżne i rozproszone", "L",
                "dr inż. Tomasz Gratkowski", "207 A-2", "D/");
        timetableEvents.add(timetableEvent);

        assertTrue(timetableDay.getEventsList().isEmpty());
        timetableDay.setEventsList(timetableEvents);
        assertFalse(timetableDay.getEventsList().isEmpty());
    }

    @Test
    public void whenConvertedToStringThenMatchPattern() {
        String dayConvertedToString =
                "TimetableDay{" +
                "name='" + "Poniedziałek" + '\'' +
                ", eventsList=" + "[]" +
                '}';

        assertEquals(dayConvertedToString, timetableDay.toString());
    }
}
