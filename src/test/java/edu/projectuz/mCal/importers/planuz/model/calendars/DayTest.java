package edu.projectuz.mCal.importers.planuz.model.calendars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTest {

    private Day day, sameDay, differentDay;
    private int number;
    private String date;
    private String dayAccordingToTimetable;
    private String dayAccordingToCalendar;

    @Before
    public void setUp() {
        number = 13;
        date = "11-01-2014";
        dayAccordingToTimetable = "Środa";
        dayAccordingToCalendar = "Czwartek";
        day = new Day(number, date, dayAccordingToTimetable, dayAccordingToCalendar);
        sameDay = new Day(number, date, dayAccordingToTimetable, dayAccordingToCalendar);
        differentDay = new Day(13, "13-01-2014", "Środa", "Czwartek");
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
                ", dayAccordingToCalendar='" + "Czwartek" + '\'' +
                '}';

        assertEquals(dayConvertedToString, day.toString());
    }

    @Test
    public void hashCodeAndEqualsMethods(){
        assertTrue(day.equals(sameDay) && sameDay.equals(day));
        assertTrue(day.hashCode() == sameDay.hashCode());
        assertFalse(day.equals(differentDay));
        assertFalse(differentDay.equals(day));
        assertFalse(differentDay.hashCode() == day.hashCode());
        assertFalse(differentDay.equals(day));
    }

    @Test
    public void gettersTest(){
        assertEquals(number, day.getNumber());
        assertEquals(date, day.getDate());
        assertEquals(dayAccordingToCalendar, day.getDayAccordingToCalendar());
        assertEquals(dayAccordingToTimetable, day.getDayAccordingToTimetable());
        assertEquals(31, day.getMagicNumber());
        Day empty = new Day();
        empty.setDate(date);
        empty.setId(number);
        empty.setDayAccordingToCalendar(dayAccordingToCalendar);
        empty.setDayAccordingToTimetable(dayAccordingToTimetable);
        empty.setNumber(22);
    }

}
