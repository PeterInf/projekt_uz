package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.hibernate.mapping.Array;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DayTest {

    private Day day;

    @Before
    public void setUp() {
        day = new Day("Poniedziałek");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(day != null);
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("Poniedziałek", day.getName());
    }

    @Test
    public void whenAddEventThenHasSomeContent() {
        TimetableEvent timetableEvent = new TimetableEvent("A", "16:55", "18:25",
                "Programowanie współbieżne i rozproszone", "L",
                "dr inż. Tomasz Gratkowski", "207 A-2", "D/");

        assertTrue(day.getEventsList().isEmpty());
        day.addEvent(timetableEvent);
        assertFalse(day.getEventsList().isEmpty());
    }

    @Test
    public void whenSetListWithContentThenListNotEmpty() {
        ArrayList<TimetableEvent> timetableEvents = new ArrayList<>();
        TimetableEvent timetableEvent = new TimetableEvent("A", "16:55", "18:25",
                "Programowanie współbieżne i rozproszone", "L",
                "dr inż. Tomasz Gratkowski", "207 A-2", "D/");
        timetableEvents.add(timetableEvent);

        assertTrue(day.getEventsList().isEmpty());
        day.setEventsList(timetableEvents);
        assertFalse(day.getEventsList().isEmpty());
    }

    @Test
    public void whenConvertedToStringThenMatchPattern() {
        String dayConvertedToString =
                "Day{" +
                "name='" + "Poniedziałek" + '\'' +
                ", eventsList=" + "[]" +
                '}';

        assertEquals(dayConvertedToString, day.toString());
    }
}
