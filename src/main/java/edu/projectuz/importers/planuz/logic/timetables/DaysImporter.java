package edu.projectuz.importers.planuz.logic.timetables;

import edu.projectuz.importers.planuz.logic.HtmlComponentName;
import edu.projectuz.importers.planuz.model.timetables.Day;
import edu.projectuz.importers.planuz.model.timetables.TimetableEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class DaysImporter {

    private String url;
    private Document htmlContent;
    private ArrayList<Day> daysList = new ArrayList<>();

    public DaysImporter(String url) {
        this.url = url;
    }

    public ArrayList<Day> importDays() {
        importHtmlContent();
        importTable();
        return daysList;
    }

    private void importHtmlContent() {
        try {
            htmlContent = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importTable() {
        if(isTimetableEmpty()) {
            daysList = null;
        } else {
            Element table = htmlContent.select(HtmlComponentName.TABLE).get(getTableIndex());
            Elements rows = table.select(HtmlComponentName.ROW);
            rows.remove(Index.ROW_WITH_HEADERS);
            importDaysListFromRows(rows);
        }
    }

    private int getTableIndex() {
        return htmlContent.select(HtmlComponentName.TABLE).size() - 1;
    }

    private void importDaysListFromRows(Elements rows) {
        Day day = null;
        for(Element row : rows) {
            if(isRowWithDayName(row)) {
                daysList.add(day);
                String dayName = row.text();
                day = new Day(dayName);
            } else {
                day.addEvent(convertRowIntoEvent(row));
            }
        }

        daysList.add(day);
        if(!daysList.isEmpty()) {
            daysList.remove(Index.NULL_ELEMENT);
        }

        if(daysList.isEmpty()) {
            daysList = null;
        }
    }

    private TimetableEvent convertRowIntoEvent(Element row) {
        Elements columns = row.select(HtmlComponentName.COLUMN);
        String subgroup = columns.get(0).text();
        String startTime = columns.get(1).text();
        String endTime = columns.get(2).text();
        String className = columns.get(3).text();
        String classType = columns.get(4).text();
        String teacherName = columns.get(5).text();
        String room = columns.get(6).text();
        String days = columns.get(7).text();

        return new TimetableEvent(subgroup, startTime, endTime, className,
                classType, teacherName, room, days);
    }

    private boolean isRowWithDayName(Element row) {
        int NUMBER_OF_COLUMNS_IN_ROW_WITH_DAY_NAME = 1;
        int numberOfColumns = row.select(HtmlComponentName.COLUMN).size();
        return numberOfColumns == NUMBER_OF_COLUMNS_IN_ROW_WITH_DAY_NAME;
    }


    /**
     * This function is kind of tricky to understand.
     * It is this way because of odd structure of planUz.
     * In very few GroupsTimetable there is additional table that
     * contains only simple text.
     * Usually table with timetable is on the second position,
     * but when there's this additional table with text,
     * the table with timetable is moved on third position.
     */
    private boolean isTimetableEmpty() {
        final int NORMAL_TIMETABLE_POSITION = 2;
        final int WITH_ADDITIONAL_TABLE = 3;

        int numberOfTables = htmlContent.select(HtmlComponentName.TABLE).size();
        int numberOfTableWithTimetable = NORMAL_TIMETABLE_POSITION;

        //change of position when there's additional table
        if (numberOfTables == WITH_ADDITIONAL_TABLE){
            numberOfTableWithTimetable = WITH_ADDITIONAL_TABLE;
        }

        return numberOfTables < numberOfTableWithTimetable;
    }
}
