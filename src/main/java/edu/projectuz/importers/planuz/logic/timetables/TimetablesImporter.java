package edu.projectuz.importers.planuz.logic.timetables;

import edu.projectuz.importers.planuz.logic.HtmlComponentName;
import edu.projectuz.importers.planuz.model.timetables.Department;
import edu.projectuz.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.importers.planuz.model.timetables.Major;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TimetablesImporter {

    private Document htmlContent;
    private String timetablesUrl = "http://plan.uz.zgora.pl/grupy_lista_kierunkow.php";

    private DepartmentsList departmentsList = new DepartmentsList();

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

        Elements majorElements = departmentElement.select(HtmlComponentName.ADDRESS);
        for (Element majorElement : majorElements) {
            department.addMajor(getMajor(majorElement));
        }
        return department;
    }

    private String getDepartmentName(Element department) {
        String departmentName = department.childNodes().get(Index.NAME_NODE).toString();
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

    private Major getMajor(Element majorElement) {
        String majorName = majorElement.text();
        String majorUrl = majorElement.attr(HtmlComponentName.URL);
        Major major = new Major(majorName);

        GroupsImporter groupsImporter = new GroupsImporter(majorUrl);
        major.setGroupTimetablesList(groupsImporter.importGroups());
        return major;
    }

}