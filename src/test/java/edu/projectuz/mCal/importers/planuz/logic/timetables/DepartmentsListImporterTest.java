package edu.projectuz.mCal.importers.planuz.logic.timetables;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DepartmentsListImporterTest {

    private DepartmentsListImporter departmentsListImporter;

    @Before
    public void setUp() {
        departmentsListImporter = new DepartmentsListImporter("http://plan.uz.zgora.pl/grupy_lista_kierunkow.php");
    }

    @Test
    public void whenDepartmentsImportedThenSizeMatches() {
        assertEquals(12, departmentsListImporter.importDepartments().size());
    }
}
