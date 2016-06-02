package edu.projectuz.mCal.exporters.ical;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.ical.logic.ICalHelper;
import edu.projectuz.mCal.importers.ical.logic.ICalRegexSections;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import java.io.*;
import java.util.ArrayList;

/**
 * This class is main class for export all data from ICal.
 */

public class ICalExporter {

    private String dateFormat = "yyyyMMddHHmmss";

    /**
     * This is function of this class.
     * It is used to export data to File.
     */

    public String generateICal(ArrayList<CalendarEvent> listOfEvents) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String tempTime;
        String tempDate;
        String tempDateTime;
        stringBuilder.append(ICalSections.BEGIN);
        stringBuilder.append(ICalSections.VCALENDAR);
        stringBuilder.append('\n');
        //Event Section
        for (CalendarEvent ev : listOfEvents){
            stringBuilder.append(ICalSections.BEGIN);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.SUMMARY);
            stringBuilder.append(ev.getTitle());
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_START);
            stringBuilder.append(ev.getStartDate());
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            tempDateTime = ev.getStartDate().toString();
            tempDate = tempDateTime.substring(0,9);
            tempTime = tempDateTime.substring(8,tempDateTime.length());
            stringBuilder.append(tempDate);
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(tempTime);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_END);
            tempDateTime =ev.getEndDate().toString();
            tempDate = tempDateTime.substring(0,9);
            tempTime = tempDateTime.substring(8,tempDateTime.length());
            stringBuilder.append(tempDate);
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(tempTime);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DESCRIPTION);
            stringBuilder.append(ev.getDescription());
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.TAG);
            stringBuilder.append("");
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




