package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() {
        department = new Department("Wydział");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertNotNull(department);
    }

    @Test
    public void whenAddToListThenNotEmpty() {
        assertTrue(department.getStudyBranchList().isEmpty());
        department.addStudyBranch(new StudyBranch("Informatyka"));
        assertFalse(department.getStudyBranchList().isEmpty());
    }

    @Test
    public void whenSetListThenNotEmpty() {
        ArrayList<StudyBranch> studyBranches = new ArrayList<>();
        studyBranches.add(new StudyBranch("Informatyka"));

        assertTrue(department.getStudyBranchList().isEmpty());
        department.setStudyBranchList(studyBranches);
        assertFalse(department.getStudyBranchList().isEmpty());
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("Wydział", department.getName());
    }

    @Test
    public void whenStudyBranchFoundThenReturnObject() throws Exception {
        department.addStudyBranch(new StudyBranch("Informatyka"));
        assertNotNull(department.getStudyBranchByName("Informatyka"));
    }

    @Test(expected = Exception.class)
    public void whenStudyBranchNotFoundThenThrowException() throws Exception {
        department.getStudyBranchByName("Zarządzanie");
    }

    @Test
    public void whenConvertedToStringThenMatchesPattern() {
        String departmentStringPattern =
                "Department{" +
                "name='" + "Wydział" + '\'' +
                ", studyBranchList=" + "[]" +
                '}';

        assertEquals(departmentStringPattern, department.toString());
    }
}
