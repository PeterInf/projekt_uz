package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupTimetableTest {

    private GroupTimetable groupTimetable;

    @Before
    public void setUp() {
        groupTimetable = new GroupTimetable("23 Inf-SP");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(groupTimetable != null);
    }

    @Test
    public void whenInitializedThenNameMatch() {
        assertEquals("23 Inf-SP", groupTimetable.getName());
    }

    @Test
    public void whenAddDayThenNoEmpty() {
        assertTrue(groupTimetable.getDaysList().isEmpty());
        groupTimetable.addDay(new Day("Wtorek"));
        assertFalse(groupTimetable.getDaysList().isEmpty());
    }

    @Test
    public void whenSetDaysListThenNoEmpty() {
        ArrayList<Day> days = new ArrayList<>();
        days.add(new Day("Poniedziałek"));

        assertTrue(groupTimetable.getDaysList().isEmpty());
        groupTimetable.setDaysList(days);
        assertFalse(groupTimetable.getDaysList().isEmpty());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void whenDayFoundThenItReturnsObject() throws Exception {
        groupTimetable.addDay(new Day("Wtorek"));
        assertNotNull(groupTimetable.getDayByName("Wtorek"));
    }

    @Test(expected = Exception.class)
    public void whenDayNotFoundThenThrowException() throws Exception {
        groupTimetable.getDayByName("Sobota");
    }

    @Test
    public void whenConvertedToStringThenMatchesPattern() {
        String groupTimetableStringPattern =
                "GroupTimetable{" +
                "name='" + "23 Inf-SP" + '\'' +
                ", daysList=" + "[]" +
                '}';

        assertEquals(groupTimetableStringPattern, groupTimetable.toString());
    }
}
