package edu.projectuz.mCal.exporters.ical;

import edu.projectuz.mCal.core.models.CalendarEvent;
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
     * It is used to create list events from model.
     */

    public ArrayList<CalendarEvent> GetDataFromModel(){
        //dostanie sie po obiekty eventow DAO/HIBERNATE
        //pobierz obiekty eventow z bazy
        ArrayList<CalendarEvent> vevents = new ArrayList<>();
        for(CalendarEvent vevent: vevents){
            vevent.add(obiektDAO);
        }
        return vevents;
    }

    /**
     * This is function of this class.
     * It is used to import data from database to ICalCalendar.
     */

    public ArrayList<CalendarEvent> CreateICalObjectFromDatabase(){
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = null;
        ArrayList<CalendarEvent> events = new ArrayList<>();

        ArrayList<CalendarEvent> vevents = GetDataFromModel();
        try {
            for (CalendarEvent ev : vevents) {
                CalendarEvent event = new CalendarEvent();
                event.setStartDate(ev.getStartDate());
                event.setEndDate(ev.getEndDate());
                event.setTitle(ev.getTitle());
                event.setDescription(ev.getDescription());
                event.setTimeZone(ev.getTimeZone());
                event.setTag("");
                events.add(event);
            }
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return events;
    }

    /**
     * This is function of this class.
     * It is used to export data to File.
     */

    public String generateICal(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String tempTime;
        String tempDate;
        String tempDateTime;
        ArrayList<CalendarEvent> calendarEvents = CreateICalObjectFromDatabase();
        stringBuilder.append(ICalSections.BEGIN);
        stringBuilder.append(ICalSections.VCALENDAR);
        stringBuilder.append('\n');
        //Event Section
        for (CalendarEvent ev : calendarEvents){
            stringBuilder.append(ICalSections.BEGIN);
            stringBuilder.append(ICalSections.VEVENT);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_START);
            stringBuilder.append(ICalSections.TIMEZONEID);
            stringBuilder.append(DateHelper.stringToTimeZone(ICalHelper.getGroupFromDate(ev.getEndDate().toString(), ICalRegexSections.TIMEZONE)));
            stringBuilder.append(ICalSections.COLONSEPARATOR);
            tempDateTime = DateHelper.stringToDate(ICalHelper.getGroupFromDate(ev.getStartDate().toString(), ICalRegexSections.DATE) +
                    ICalHelper.getGroupFromDate(ev.getStartDate().toString(), ICalRegexSections.TIME), dateFormat);
            tempDate = tempDateTime.substring(0,9);
            tempTime = tempDateTime.substring(8,tempDateTime.length());
            stringBuilder.append(tempDate);
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(tempTime);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.DATE_END);
            tempDateTime =DateHelper.stringToDate(ICalHelper.getGroupFromDate(ev.getEndDate().toString(),  ICalRegexSections.DATE) +
                    ICalHelper.getGroupFromDate(ev.getEndDate().toString(), ICalRegexSections.TIME), dateFormat);
            tempDate = tempDateTime.substring(0,9);
            tempTime = tempDateTime.substring(8,tempDateTime.length());
            stringBuilder.append(tempDate);
            stringBuilder.append(ICalSections.TSEPARATOR);
            stringBuilder.append(tempTime);
            stringBuilder.append('\n');
            stringBuilder.append(ICalSections.SUMMARY);
            stringBuilder.append(ev.getTitle());
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




