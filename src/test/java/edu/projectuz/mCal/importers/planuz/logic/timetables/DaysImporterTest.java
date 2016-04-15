package edu.projectuz.mCal.importers.planuz.logic.timetables;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DaysImporterTest {

    private DaysImporter daysImporter;

    @Before
    public void setUp() {
        daysImporter = new DaysImporter("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16671");
    }

    /**
     * Later on (near end of semester) this test can fail because
     * some days probably would disappear from the timetable.
     */
    @Test
    public void whenImportDaysThenSizeMatches() {
        assertEquals(5, daysImporter.importDays().size());
    }

}
