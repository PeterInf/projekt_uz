package edu.projectuz.mCal.exporters.csv;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

/**
 * This class is main class for exporter all data from this app to string.
 */
public class CsvExporterToString {

    /**
     * This function returned a string of all events.
     * @param listOfEvents list of all events.
     * @return list of events in string.
     */
    public String generateCsvToString(ArrayList<CalendarEvent> listOfEvents) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ",";
        String dateFormat = ("MM/dd/yyyy");
        String timeFormat = ("HH:mm a");
        DateTimeFormatter formatterDate = DateTimeFormat.forPattern(dateFormat);
        DateTimeFormatter formatterTime = DateTimeFormat.forPattern(timeFormat);

        stringBuilder.append("Subject");
        stringBuilder.append(separator);
        stringBuilder.append("Start Date");
        stringBuilder.append(separator);
        stringBuilder.append("Start Time");
        stringBuilder.append(separator);
        stringBuilder.append("End Date");
        stringBuilder.append(separator);
        stringBuilder.append("End Time");
        stringBuilder.append(separator);
        stringBuilder.append("All Day Event");
        stringBuilder.append(separator);
        stringBuilder.append("Description");
        stringBuilder.append(separator);
        stringBuilder.append("Location");
        stringBuilder.append(separator);
        stringBuilder.append("Private");
        stringBuilder.append(System.lineSeparator());

        for (CalendarEvent calendarEvent : listOfEvents) {
            stringBuilder.append(calendarEvent.getTitle());
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getStartDate().toString(formatterDate));
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getStartDate().toString(formatterTime));
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getEndDate().toString(formatterDate));
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getEndDate().toString(formatterTime));
            stringBuilder.append(separator);
            stringBuilder.append(false);
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getDescription());
            stringBuilder.append(separator);
            stringBuilder.append(calendarEvent.getTag());
            stringBuilder.append(separator);
            stringBuilder.append(false);
            stringBuilder.append(separator);
        }
        return stringBuilder.toString();
    }
}