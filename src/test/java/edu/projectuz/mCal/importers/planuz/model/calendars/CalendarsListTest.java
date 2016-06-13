package edu.projectuz.mCal.importers.planuz.model.calendars;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalendarsListTest {

    private CalendarsList calendarsList;
    private ArrayList<Calendar> calendars = new ArrayList<>();
    private String description;

    @Before
    public void setUp() {
        description = "Kalendarze na rok 2015/2016";
        calendarsList = new CalendarsList(description);

        Calendar calendar = new Calendar("D", "Studia stacjonarne");

        DaysList daysList1 = new DaysList("Type1");
        daysList1.addDay(new Day(12, "26-02-2016", "Piątek", "Piątek"));
        daysList1.addDay(new Day(1, "13-01-2016", "Czwartek", "Czwartek"));

        DaysList daysList2 = new DaysList("Type2");
        daysList2.addDay(new Day(2, "18-03-2016", "Piątek", "Piątek"));
        daysList2.addDay(new Day(3, "26-02-2016", "Poniedziałek", "Poniedziałek"));

        ArrayList<DaysList> daysLists = new ArrayList<>();
        daysLists.add(daysList1);
        daysLists.add(daysList2);

        calendar.setDaysLists(daysLists);

        calendars.add(calendar);
        calendarsList.setListOfCalendars(calendars);
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(calendarsList != null);
    }

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void whenCalendarAddedThenItCanBeFound() throws Exception {
        calendarsList.addCalendar(new Calendar("Kalendarz", "Opis"));
        calendarsList.getCalendarByName("Kalendarz");
    }

    @Test(expected = Exception.class)
    public void whenNoCalendarFoundThenThrowException() throws Exception {
        calendarsList.getCalendarByName("Kalendarz123");
    }

    @Test(expected = Exception.class)
    public void whenNewCalendarsListThenOldCannotBeFound() throws Exception {
        ArrayList<Calendar> newCalendars = new ArrayList<>();
        newCalendars.add(new Calendar("Kalendarz11", "Opis11"));
        newCalendars.add(new Calendar("Kalendarz12", "Opis12"));

        calendarsList.setListOfCalendars(newCalendars);
        calendarsList.getCalendarByName("Kalendarz");
    }

    @Test
    public void whenGetCalendarsListThenCountMatches() {
        assertEquals(1, calendarsList.getListOfCalendars().size());
    }

    @Test
    public void whenConvertedToStringThenMatchThePattern() {
        String calendarsListConvertedToString =
                "CalendarsList{" +
                "description='" + "Kalendarze na rok 2015/2016" + '\'' +
                ", calendars=" + calendars +
                '}';
        assertEquals(calendarsListConvertedToString, calendarsList.toString());
    }

    @Test
    public void gettersAndSettersTests(){
        CalendarsList calendarsListEmpty = new CalendarsList();
        assertNotNull(calendarsListEmpty);
        int id = 1;
        String description = "description";
        ArrayList<Calendar> calendars = new ArrayList<>();
        calendarsListEmpty.setId(id);
        calendarsListEmpty.setDescription(description);
        calendarsListEmpty.setCalendars(calendars);
        assertEquals(id, calendarsListEmpty.getId());
        assertEquals(description, calendarsListEmpty.getDescription());
        assertEquals(calendars, calendarsListEmpty.getCalendars());
        assertEquals(0, calendarsListEmpty.size());

    }
}
