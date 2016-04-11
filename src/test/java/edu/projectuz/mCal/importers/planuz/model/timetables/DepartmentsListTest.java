package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartmentsListTest {

    private DepartmentsList departmentsList;

    @Before
    public void setUp() {
        departmentsList = new DepartmentsList();
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertNotNull(departmentsList);
    }

    @Test
    public void whenAddThenNotEmpty() {
        assertTrue(departmentsList.getDepartmentsList().isEmpty());
        departmentsList.addDepartment(new Department("Wydział1"));
        assertFalse(departmentsList.getDepartmentsList().isEmpty());
    }

    @Test
    public void whenSetListThenNotEmpty() {
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("Wydział2"));

        assertTrue(departmentsList.getDepartmentsList().isEmpty());
        departmentsList.setDepartmentsList(departments);
        assertFalse(departmentsList.getDepartmentsList().isEmpty());
    }

    @Test
    public void whenDepartmentFoundThenReturnObject() throws Exception {
        departmentsList.addDepartment(new Department("Wydział"));
        assertNotNull(departmentsList.getDepartmentByName("Wydział"));
    }

    @Test(expected = Exception.class)
    public void whenStudyBranchNotFoundThenThrowException() throws Exception {
        departmentsList.getDepartmentByName("Wydział11");
    }

    @Test
    public void whenConvertedToStringThenMatchesPattern() {
        String departmentsListStringPattern =
                "DepartmentsList{" +
                        "departmentsList=" + "[]" +
                        '}';

        assertEquals(departmentsListStringPattern, departmentsList.toString());
    }
}
