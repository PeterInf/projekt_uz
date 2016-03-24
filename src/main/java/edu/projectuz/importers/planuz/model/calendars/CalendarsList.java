package edu.projectuz.importers.planuz.model.calendars;

import java.util.ArrayList;

public class CalendarsList {

    private String description;
    private ArrayList<Calendar> calendars = new ArrayList<>();

    public CalendarsList(String description) {
        this.description = description;
    }

    public void addCalendar(Calendar calendar) {
        calendars.add(calendar);
    }

    public void setListOfCalendars(ArrayList<Calendar> calendars) {
        this.calendars = calendars;
    }

    public Calendar getCalendarByName(String name) {
        for(Calendar calendar : calendars) {
            if(calendar.getName().equals(name)) {
                return calendar;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CalendarsList{" +
                "description='" + description + '\'' +
                ", calendars=" + calendars +
                '}';
    }
}
