package edu.projectuz.mCal.exporters.ical;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.*;
import java.util.ArrayList;


/**
 * This class is main class for export all data from ICal.
 */

public class ICalExporter {

    private String dateFormat = "yyyyMMdd";
    private String timeFormat = ("HHmmss");
    DateTimeFormatter formatterDate = DateTimeFormat.forPattern(dateFormat);
    DateTimeFormatter formatterTime = DateTimeFormat.forPattern(timeFormat);

    /**
     * This is function of this class.
     * It is used to export data to File.
     */

    public String generateICal(ArrayList<CalendarEvent> listOfEvents) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ICalSections.BEGIN);
        stringBuilder.append(ICalSections.VCALENDAR);
        stringBuilder.append('\n');

        //Event Section
        for (CalendarEvent calendarEvent : listOfEvents){
            stringBuilder.append(ICalSections.BEGIN);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.SUMMARY);
            stringBuilder.append(calendarEvent.getTitle());
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_START);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(calendarEvent.getStartDate().toString(formatterDate));
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(calendarEvent.getStartDate().toString(formatterTime));
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_END);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(calendarEvent.getEndDate().toString(formatterDate));
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(calendarEvent.getEndDate().toString(formatterTime));
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DESCRIPTION);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(calendarEvent.getDescription());
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.TAG);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(" ");
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.END);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
        }

        stringBuilder.append(ICalSections.END);
        stringBuilder.append(ICalSections.VCALENDAR);
        return stringBuilder.toString();
    }
}




