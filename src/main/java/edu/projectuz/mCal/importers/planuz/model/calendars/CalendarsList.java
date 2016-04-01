package edu.projectuz.mCal.importers.planuz.model.calendars;

import edu.projectuz.mCal.importers.planuz.logic.calendars.CalendarsListImporter;

import java.util.ArrayList;

/**
 * This class stores all the information about every planUz calendar.
 * It's a root of calendars hierarchy.
 * It keeps this information in a list of {@link Calendar} objects.
 * Instance of this class is returned by {@link CalendarsListImporter}.
 */
public class CalendarsList {

    private String description;
    private ArrayList<Calendar> calendars = new ArrayList<>();

    /**
     * Class constructor that simply sets a value of description variable.
     * @param description - simple description of all calendars.
     *                    For example:
     *                    Lista kalendarzy - semestr letni 2015/2016
     */
    public CalendarsList(String description) {
        this.description = description;
    }

    /**
     * This method allows you to add single calendar to the list.
     * @param calendar - {@link Calendar} to add.
     */
    public void addCalendar(Calendar calendar) {
        calendars.add(calendar);
    }

    /**
     * This methods sets calendars list to this passed by the parameter.
     * @param calendars - a list of {@link Calendar} to set.
     */
    public void setListOfCalendars(ArrayList<Calendar> calendars) {
        this.calendars = calendars;
    }

    /**
     * This function allows you to search a {@link Calendar} by it's name.
     * If calendar is not found it throws an exception.
     * @param name - name of a {@link Calendar} to find.
     * @return Returns {@link Calendar} object that was found.
     */
    public Calendar getCalendarByName(String name) throws Exception {
        for(Calendar calendar : calendars) {
            if(calendar.getName().equals(name)) {
                return calendar;
            }
        }
        throw new Exception("Calendar with name \'" + name + "\' not found.");
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "CalendarsList{" +
                "description='" + description + '\'' +
                ", calendars=" + calendars +
                '}';
    }
}
