package edu.projectuz.mCal.importers.planuz;

import edu.projectuz.mCal.importers.planuz.logic.calendars.CalendarsListImporter;
import edu.projectuz.mCal.importers.planuz.logic.timetables.DepartmentsListImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class PlanUzConverterTest {

    private PlanUzConverter planUzConverter;
    private GroupTimetable groupTimetable;

    /**
     * This information won't test 100% of code, but for now it's better,
     * because is more stable. Tests won't fail so often.
     */
    @Before
    public void setUp() throws Exception {
        planUzConverter = new PlanUzConverter(new CalendarsListImporter("http://plan.uz.zgora.pl/kalendarze_lista.php").
                importCalendars().getListOfCalendars());
        groupTimetable = new DepartmentsListImporter("http://plan.uz.zgora.pl/grupy_lista_kierunkow.php").
                importDepartments().getDepartmentByName("Wydział Artystyczny").
                getStudyBranchByName("Grafika").
                getGroupTimetableByName("21GRAFIKASP (Grafika stacjonarne-dzienne pierwszego stopnia z tyt. licencjata)");
    }

    @Test
    public void whenConvertingTimetableEventsCountMatches() {
        assertEquals(6, planUzConverter.convertTimetable(groupTimetable).size());
    }

    @Test
    public void planIsNotNull(){
        assertNotNull(planUzConverter);
    }
}
