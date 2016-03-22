package edu.projectuz.importers.planuz.logic.timetables;

import edu.projectuz.importers.planuz.logic.HtmlComponentName;
import edu.projectuz.importers.planuz.model.timetables.GroupTimetable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class GroupsImporter {

    private String url;

    private ArrayList<GroupTimetable> groupTimetablesList = new ArrayList<>();
    private Document htmlContent;

    public GroupsImporter(String url) {
        this.url = url;
    }

    public ArrayList<GroupTimetable> importGroups() {
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
        Element table = htmlContent.select(HtmlComponentName.TABLE).get(Index.GROUPS_TABLE);
        Elements rows = table.select(HtmlComponentName.ROW);

        for(Element row : rows) {
            String groupName = row.text();
            String groupUrl = row.select(HtmlComponentName.ADDRESS).attr(HtmlComponentName.URL);

            GroupTimetable groupTimetable = new GroupTimetable(groupName);
            DaysImporter daysImporter = new DaysImporter(groupUrl);

            groupTimetable.setDaysList(daysImporter.importDays());
            groupTimetablesList.add(groupTimetable);
        }
    }

}
