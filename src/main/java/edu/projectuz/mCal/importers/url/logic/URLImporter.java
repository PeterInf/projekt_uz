package edu.projectuz.mCal.importers.url.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.url.model.UrlSections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class UrlImporter extends BaseEventImporter {

    private Elements inputElements;

    public UrlImporter(final String sourcePath,
                       final ImporterSourceType sourceType)
            throws IOException {
        super(sourcePath, sourceType);
    }

    public final ArrayList<CalendarEvent> convertToObject() {
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();
        String dateFormat = "yyyy/MM/dd HH:mm";
        importData();

        for (Element row : inputElements) {
            Elements elements = row.select("td");
            CalendarEvent calendarEvent = new CalendarEvent();

            calendarEvent.setTitle(elements.get(UrlSections.TITLE).text());
            calendarEvent.setStartDate(DateHelper.stringToDate(
                    elements.get(UrlSections.DATE_START).text(),
                    dateFormat, DateHelper.stringToTimeZone(
                            elements.get(UrlSections.TIME_ZONE).text())));
            calendarEvent.setEndDate(DateHelper.stringToDate(
                    elements.get(UrlSections.DATE_END).text(),
                    dateFormat, DateHelper.stringToTimeZone(
                            elements.get(UrlSections.TIME_ZONE).text())));
            calendarEvent.setDescription(
                    elements.get(UrlSections.DESCRIPTION).text());
            calendarEvent.setTag(elements.get(UrlSections.TAG).text());
            calendarEvent.setTimeZone(DateHelper.stringToTimeZone(
                    elements.get(UrlSections.TIME_ZONE).text()));
            listOfEvents.add(calendarEvent);
        }
        return listOfEvents;
    }

    @Override
    public final String getName() {
        return "URL Importer";
    }

    @Override
    public final void importData() {
        Document document = Jsoup.parse(getSourceContent());
        Element table = document.getElementById("exampleTable");
        inputElements = table.getElementsByTag("tr");
        inputElements.remove(0);
    }
}
