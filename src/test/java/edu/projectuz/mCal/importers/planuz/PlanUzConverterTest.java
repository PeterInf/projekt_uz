package edu.projectuz.mCal.importers.planuz;

import edu.projectuz.mCal.importers.planuz.logic.timetables.DepartmentsListImporter;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlanUzConverterTest {

    private PlanUzConverter planUzConverter;
    private GroupTimetable groupTimetable;

    @Before
    public void setUp() throws Exception {
        planUzConverter = new PlanUzConverter();
        groupTimetable = new DepartmentsListImporter("http://plan.uz.zgora.pl/grupy_lista_kierunkow.php").
                importDepartments().getDepartmentByName("Wydział Informatyki, Elektrotechniki i Automatyki").
                getStudyBranchByName("Informatyka").
                getGroupTimetableByName("23INF-SP (Informatyka stacjonarne-dzienne pierwszego stopnia z tyt. inżyniera)");
    }

    @Test
    public void whenConvertingTimetableEventsCountMatches() {
        assertEquals(221, planUzConverter.convertTimetable(groupTimetable).size());
    }
}
