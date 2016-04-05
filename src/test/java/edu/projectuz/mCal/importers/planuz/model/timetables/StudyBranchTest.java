package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class StudyBranchTest {

    private StudyBranch studyBranch;

    @Before
    public void setUp() {
        studyBranch = new StudyBranch("Informatyka");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertNotNull(studyBranch);
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("Informatyka", studyBranch.getName());
    }

    @Test
    public void whenAddTimetableThenNoEmpty() {
        assertTrue(studyBranch.getGroupTimetablesList().isEmpty());
        studyBranch.addGroupTimetable(new GroupTimetable("23 Inf"));
        assertFalse(studyBranch.getGroupTimetablesList().isEmpty());
    }

    @Test
    public void whenSetTimetablesListThenNoEmpty() {
        ArrayList<GroupTimetable> groupTimetables = new ArrayList<>();
        groupTimetables.add(new GroupTimetable("23 Inf"));

        assertTrue(studyBranch.getGroupTimetablesList().isEmpty());
        studyBranch.setGroupTimetablesList(groupTimetables);
        assertFalse(studyBranch.getGroupTimetablesList().isEmpty());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void whenGroupTimetableFoundThenReturnObject() throws Exception {
        studyBranch.addGroupTimetable(new GroupTimetable("23 Inf"));
        assertNotNull(studyBranch.getGroupTimetableByName("23 Inf"));
    }

    @Test(expected = Exception.class)
    public void whenGroupTimetableNotFoundThenThrowException() throws Exception {
        studyBranch.getGroupTimetableByName("23 Inf-SP");
    }

    @Test
    public void whenConvertedToStringThenMatchPattern() {
        String studyBranchStringPattern =
                "StudyBranch{" +
                "name='" + "Informatyka" + '\'' +
                ", groupTimetablesList=" + "[]" +
                '}';

        assertEquals(studyBranchStringPattern, studyBranch.toString());
    }

}
