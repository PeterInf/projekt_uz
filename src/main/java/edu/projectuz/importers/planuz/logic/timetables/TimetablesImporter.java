package edu.projectuz.importers.planuz.logic.timetables;

import edu.projectuz.importers.planuz.logic.HtmlComponentName;
import edu.projectuz.importers.planuz.model.timetables.Department;
import edu.projectuz.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.importers.planuz.model.timetables.StudyBranch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * This is a main class for importing planUz timetables.
 * It returns {@link DepartmentsList} object. It's structure
 * is very similar to structure of planUz website.
 * <br>
 * You can use this structure to access every single element of
 * a timetable you want starting with main function of this class
 * {@link #importTimetables()}.
 * <br>
 * For example:
 * <br>
 * new TimetablesImporter().importTimetables().
 * getDepartmentByName("Wydział Prawa i Administracji").getStudyBranchByName("Administracja").
 * getGroupTimetableByName("11ADM-SP (Administracja stacjonarne-dzienne pierwszego stopnia z tyt. licencjata)").
 * getDayByName("Poniedziałek"));
 */
public class TimetablesImporter {

    private Document htmlContent;
    private String timetablesUrl = "http://plan.uz.zgora.pl/grupy_lista_kierunkow.php";

    private DepartmentsList departmentsList = new DepartmentsList();

    /**
     * Main function of this class. It allows you to import every planUz timetable.
     * @return Returns {@link DepartmentsList} which is a root of planUz hierarchy.
     */
    public DepartmentsList importTimetables() {
        importHtmlContent();
        return getDepartmentsList();
    }

    private void importHtmlContent() {
        try {
            htmlContent = Jsoup.connect(timetablesUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DepartmentsList getDepartmentsList() {
        Element listWithDepartments = htmlContent.select(HtmlComponentName.LIST).first();
        Elements departments = listWithDepartments.children();

        for(Element departmentElement : departments) {
            departmentsList.addDepartment(getDepartment(departmentElement));
        }

        return departmentsList;
    }

    private Department getDepartment(Element departmentElement) {
        String departmentName = getDepartmentName(departmentElement);
        Department department = new Department(departmentName);

        Elements studyBranchElements = departmentElement.select(HtmlComponentName.ADDRESS);
        for (Element studyBranchElement : studyBranchElements) {
            department.addStudyBranch(getStudyBranch(studyBranchElement));
        }
        return department;
    }

    private String getDepartmentName(Element department) {
        String departmentName = department.childNodes().get(TimetableComponentIndex.NAME_NODE).toString();
        return getNameWithoutSpaceAtTheEnd(departmentName);
    }

    /**
     * This function is necessary because in planUz Department's name there's a space
     * at the end of every single name, so it have to be deleted, because
     * searching Departments by name wouldn't work with this space at the end.
     */
    private String getNameWithoutSpaceAtTheEnd(String departmentName) {
        final int NAME_START_INDEX = 0;
        final int NUMBER_OF_CHARACTERS_TO_DELETE = 1;
        return departmentName.substring(NAME_START_INDEX,
                departmentName.length() - NUMBER_OF_CHARACTERS_TO_DELETE);
    }

    private StudyBranch getStudyBranch(Element studyBranchElement) {
        String studyBranchName = studyBranchElement.text();
        String studyBranchUrl = studyBranchElement.attr(HtmlComponentName.URL);
        StudyBranch studyBranch = new StudyBranch(studyBranchName);

        GroupsImporter groupsImporter = new GroupsImporter(studyBranchUrl);
        studyBranch.setGroupTimetablesList(groupsImporter.importGroups());
        return studyBranch;
    }

}