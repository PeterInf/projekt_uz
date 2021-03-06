package edu.projectuz.mCal.importers.planuz.logic.timetables;

import edu.projectuz.mCal.importers.planuz.model.timetables.StudyBranch;
import edu.projectuz.mCal.importers.planuz.logic.HtmlComponentName;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used for importing timetables of
 * every group from one {@link StudyBranch}.
 * It is used by {@link DepartmentsListImporter}
 */
class GroupsImporter {

    private String url;

    private ArrayList<GroupTimetable> groupTimetablesList = new ArrayList<>();
    private Document htmlContent;

    /**
     * Class constructor which simply sets a value of url variable.
     *
     * @param anUrl - stores information about url address of
     *              HTML content with every group
     *              of particular {@link StudyBranch}
     */
    GroupsImporter(final String anUrl) {
        this.url = anUrl;
    }

    /**
     * Main function of this class. It imports
     *
     * @return Returns a list of {@link GroupTimetable} objects that
     * stores information about every group from particular {@link StudyBranch}
     */
    ArrayList<GroupTimetable> importGroups() {
        importHtmlContent();
        importTable();
        return groupTimetablesList;
    }

    private void importHtmlContent() {
        try {
            htmlContent = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importTable() {
        Element table = htmlContent.select(HtmlComponentName.TABLE).
                get(TimetableComponentIndex.GROUPS_TABLE);
        Elements rows = table.select(HtmlComponentName.ROW);

        for (Element row : rows) {
            String groupName = row.text();
            String groupUrl = row.select(HtmlComponentName.ADDRESS).
                    attr(HtmlComponentName.ABSOLUTE_URL);

            GroupTimetable groupTimetable = new GroupTimetable(groupName);
            DaysImporter daysImporter = new DaysImporter(groupUrl);

            groupTimetable.setDaysList(daysImporter.importDays());
            groupTimetablesList.add(groupTimetable);
        }
    }

}
