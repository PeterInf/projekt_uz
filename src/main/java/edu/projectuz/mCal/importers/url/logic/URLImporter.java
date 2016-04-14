package edu.projectuz.mCal.importers.url.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.url.model.URLSections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class URLImporter extends BaseEventImporter {

    private Elements inputElements;

    public URLImporter(String sourcePath, ImporterSourceType sourceType) throws IOException {
        super(sourcePath, sourceType);
    }

    public ArrayList<CalendarEvent> convertToObject() {
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();
        String dateFormat = "yyyy/MM/dd hh:mm";
        importData();

        for (Element row : inputElements) {
            Elements elements = row.select("td");
            CalendarEvent calendarEvent = new CalendarEvent();

            calendarEvent.setTitle(elements.get(URLSections.TITLE).text());
            calendarEvent.setStartDate(DateHelper.stringToDate(elements.get(URLSections.DATE_START).text(),
                    dateFormat, DateHelper.stringToTimeZone(elements.get(URLSections.TIME_ZONE).text())));
            calendarEvent.setEndDate(DateHelper.stringToDate(elements.get(URLSections.DATE_END).text(),
                    dateFormat, DateHelper.stringToTimeZone(elements.get(URLSections.TIME_ZONE).text())));
            calendarEvent.setDescription(elements.get(URLSections.DESCRIPTION).text());
            calendarEvent.setTag(elements.get(URLSections.TAG).text());
            calendarEvent.setTimeZone(DateHelper.stringToTimeZone(elements.get(URLSections.TIME_ZONE).text()));
            listOfEvents.add(calendarEvent);
        }
        return listOfEvents;
    }

    @Override
    public String getName() {
        return "URL Importer";
    }

    @Override
    public void importData() {
        Document document = Jsoup.parse(getSourceContent());
        Element table = document.getElementById("exampleTable");
        inputElements = table.getElementsByTag("tr");
        inputElements.remove(0);
    }
}