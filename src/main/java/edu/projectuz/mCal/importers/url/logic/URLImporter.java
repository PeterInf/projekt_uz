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


    public URLImporter(String sourcePath, ImporterSourceType sourceType) throws IOException {
        super(sourcePath, sourceType);
    }

    public ArrayList<CalendarEvent> convertHTMLTableToObject() {
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();
        String dateFormat = "yyyy/MM/dd HH:mm";
        Document document = Jsoup.parse(getSourceContent());

        Element table = document.getElementById("exampleTable");
        Elements inputElements = table.getElementsByTag("tr");
        inputElements.remove(0);

            for (Element row : inputElements) {
                helperForParser(row, listOfEvents, dateFormat);
            }
        return listOfEvents;
    }

    private void helperForParser(Element row, ArrayList<CalendarEvent> listOfEvents, String dateFormat) {
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

    @Override
    public String getName() {
        return "URL Importer";
    }

    @Override
    public void importData() {

    }
}