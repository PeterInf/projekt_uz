package edu.projectuz.mCal.importers.planuz.model.calendars;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DaysListTest {

    private DaysList daysList;

    @Before
    public void setUp() {
        daysList = new DaysList("D");
        daysList.addDay(new Day(12, "26-02-2016", "Piątek", "Piątek"));
        daysList.addDay(new Day(1, "13-01-2016", "Czwartek", "Czwartek"));
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(daysList != null);
    }

    @Test
    public void whenInitializedThenTypeMatches() {
        assertEquals("D", daysList.getType());
    }

    @Test
    public void whenGetByDateThatExistsThenTrue() throws Exception {
        assertEquals(
                new Day(12, "26-02-2016", "Piątek", "Piątek"),
                daysList.getDayByDate("26-02-2016"));
    }

    @Test(expected = Exception.class)
    public void whenGetByDateThatDoNotExistThenThrowException() throws Exception {
        daysList.getDayByDate("11-01-2000");
    }

    @Test
    public void whenConvertedToStringThenMatchesPattern() {
        String daysListConvertedToString =
                "DaysList{" +
                "type='" + "D" + '\'' +
                ", days=" + daysList.getDays() +
                '}';

        assertEquals(daysListConvertedToString, daysList.toString());
    }
}
