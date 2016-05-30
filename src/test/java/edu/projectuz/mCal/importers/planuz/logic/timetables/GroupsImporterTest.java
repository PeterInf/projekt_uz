package edu.projectuz.mCal.importers.planuz.logic.timetables;

import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GroupsImporterTest {

    private GroupsImporter groupsImporter;

    @Before
    public void setUp() {
        groupsImporter = new GroupsImporter("http://plan.uz.zgora.pl/grupy_lista_grup_kierunku.php?pId_kierunek=401");
    }

    @Test
    public void whenImportGroupsThenSizeMatches() {
        assertEquals(17, groupsImporter.importGroups().size());
    }
}
