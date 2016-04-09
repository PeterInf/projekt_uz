package edu.projectuz.mCal.importers.planuz.model.calendars;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalendarTest {

    private Calendar calendar;
    private ArrayList<DaysList> daysLists = new ArrayList<>();
    private DaysList daysList1;
    private DaysList daysList2;

    @Before
    public void setUp() {
        calendar = new Calendar("D", "Studia stacjonarne");

        daysList1 = new DaysList("Type1");
        daysList1.addDay(new Day(12, "26-02-2016", "Piątek", "Piątek"));
        daysList1.addDay(new Day(1, "13-01-2016", "Czwartek", "Czwartek"));

        daysList2 = new DaysList("Type2");
        daysList2.addDay(new Day(2, "18-03-2016", "Piątek", "Piątek"));
        daysList2.addDay(new Day(3, "26-02-2016", "Poniedziałek", "Poniedziałek"));

        daysLists.add(daysList1);
        daysLists.add(daysList2);

        calendar.setDaysLists(daysLists);
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(calendar != null);
    }

    @Test
    public void whenDaysListFoundThenTrue() throws Exception {
         assertEquals(daysList1, calendar.getDaysListByType("Type1"));
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("D", calendar.getName());
    }

    @Test(expected = Exception.class)
    public void whenGetAndDaysListNotFoundThrowException() throws Exception {
        calendar.getDaysListByType("Type4");
    }

    @Test
    public void whenConvertedToStringThenMatchPattern() {
        String calendarConvertedToString =
                "Calendar{" +
                "name='" + "D" + '\'' +
                ", description='" + "Studia stacjonarne" + '\'' +
                ", daysLists=" + daysLists +
                '}';

        assertEquals(calendarConvertedToString, calendar.toString());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void whenCalendarsListAddedThenCanBeFound() throws Exception {
        DaysList daysList = new DaysList("Type3");
        daysList.addDay(new Day(1, "26-06-2016", "Niedziela", "Niedziela"));
        daysList.addDay(new Day(14, "06-09-2016", "Poniedziałek", "Poniedziałek"));

        calendar.addDaysList(daysList);
        calendar.getDaysListByType("Type3");
    }

    @Test(expected = Exception.class)
    public void whenListsSetToDifferentOldListsNotFound() throws Exception {
        DaysList daysList = new DaysList("Type3");
        daysList.addDay(new Day(1, "26-06-2016", "Niedziela", "Niedziela"));
        daysList.addDay(new Day(14, "06-09-2016", "Poniedziałek", "Poniedziałek"));

        ArrayList<DaysList> daysLists = new ArrayList<>();
        daysLists.add(daysList);
        calendar.setDaysLists(daysLists);
        calendar.getDaysListByType("Type1");
    }

}