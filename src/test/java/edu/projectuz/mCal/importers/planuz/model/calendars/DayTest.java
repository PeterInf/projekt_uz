package edu.projectuz.mCal.importers.planuz.model.calendars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTest {

    private Day day;

    @Before
    public void setUp() {
        day = new Day(13, "11-01-2014", "Środa", "Czwartek");
    }

    @Test
    public void whenDayInitializedThenNotNull() {
        assertTrue(day != null);
    }

    @Test
    public void whenCompareTwoIdenticalObjectsThenTrue() {
        assertEquals(day, new Day(13, "11-01-2014", "Środa", "Czwartek"));
    }

    @Test
    public void whenCompareTwoDifferentObjectsThenFalse() {
        assertNotEquals(day, new Day(1, "10-02-2011", "Wtorek", "Środa"));
        assertNotEquals(day, new Day(13, "11-01-2014", "Czwartek", "Czwartek"));
        assertNotEquals(day, new Day(1, "11-01-2014", "Środa", "Czwartek"));
    }

    @Test
    public void whenCompareObjectWithItselfThenTrue() {
        assertEquals(day, day);
    }

    @Test
    public void whenCompareObjectWithNullThenFalse() {
        assertNotEquals(null, day);
        assertFalse(day.equals(null));
    }

    @Test
    public void whenCompareToDifferentClassObjectThenFalse() {
        assertFalse(day.equals(3));
    }

    @Test
    public void whenDayInitializedThenDatesAreEqual() {
        assertEquals("11-01-2014", day.getDate());
    }

    @Test
    public void whenDayConvertedToStringThenMatchPattern() {
        String dayConvertedToString = "Day{" +
                "number=" + 13 +
                ", date=" + "11-01-2014" +
                ", dayAccordingToTimetable='" + "Środa" + '\'' +
                ", getDayAccordingToCalendar='" + "Czwartek" + '\'' +
                '}';

        assertEquals(dayConvertedToString, day.toString());
    }

}
