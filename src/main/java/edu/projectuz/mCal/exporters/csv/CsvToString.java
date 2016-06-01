package edu.projectuz.mCal.exporters.csv;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.csv.model.CSVSections;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class CsvToString {

    public String convert(ArrayList<CalendarEvent> listOfEvents) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ",";
        String dateFormat = ("yyyy/MM/dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);

        stringBuilder.append(CSVSections.TITLE);
        stringBuilder.append(separator);
        stringBuilder.append(CSVSections.DATE_START);
        stringBuilder.append(separator);
        stringBuilder.append(CSVSections.DATE_END);
        stringBuilder.append(separator);
        stringBuilder.append(CSVSections.DESCRIPTION);
        stringBuilder.append(separator);
        stringBuilder.append(CSVSections.TAG);
        stringBuilder.append(separator);
        stringBuilder.append(CSVSections.TIME_ZONE);
        stringBuilder.append(System.lineSeparator());

        for (CalendarEvent calendarEvent : listOfEvents) {
            stringBuilder.append(calendarEvent.getTitle());
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getStartDate().toString(formatter));
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getEndDate().toString(formatter));
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getDescription());
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getTag());
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getTimeZone().getID());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}