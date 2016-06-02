package edu.projectuz.mCal.exporters.ical;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.ical.logic.ICalHelper;
import edu.projectuz.mCal.importers.ical.logic.ICalRegexSections;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.TimeZone;

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
/*
    public static void main(){
        new ICalExporter();
    }

    ICalExporter(){
        CalendarEvent calendarEvent = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));
        CalendarEvent calendarEvent1 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 00:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), "OPIS", "f", TimeZone.getTimeZone("Europe/Warsaw"));
        ArrayList<CalendarEvent> calendarEvents = new ArrayList<>();
        calendarEvents.add(calendarEvent1);
        calendarEvents.add(calendarEvent);
        try {
            generateICalFile(generateICal(calendarEvents),"C:\\Users\\Sivik\\Desktop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File generateICalFile(String text, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
*/
    public String generateICal(ArrayList<CalendarEvent> listOfEvents) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ICalSections.BEGIN);
        stringBuilder.append(ICalSections.COLONSEPARATOR);
        stringBuilder.append(ICalSections.VCALENDAR);
        stringBuilder.append('\n');

        //Event Section
        for (CalendarEvent calendarEvent : listOfEvents){
            stringBuilder.append(ICalSections.BEGIN);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.SUMMARY);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
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
            stringBuilder.append(false);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.END);
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
        }

        stringBuilder.append(ICalSections.END);
        stringBuilder.append(ICalSections.COLONSEPARATOR);
        stringBuilder.append(ICalSections.VCALENDAR);
        return stringBuilder.toString();
    }
}




