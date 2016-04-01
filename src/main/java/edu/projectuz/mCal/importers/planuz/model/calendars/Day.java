package edu.projectuz.mCal.importers.planuz.model.calendars;

/**
 * This class is the lowest in planUz calendars hierarchy.
 * Instance of this class represents single day of calendar.
 * It stores information about day number, date and two different names.
 * This two names are necessary because sometimes one particular day
 * of the week there is treated as if it was some other day.
 * For example: one day there'a a friday but all of the classes are
 * by a monday schedule.
 * It's a part of {@link DaysList} class.
 */
public class Day {

    private int number;
    private String date;
    private String dayAccordingToTimetable;
    private String getDayAccordingToCalendar;

    /**
     * Class constructor that simply sets all of the member variables describing day.
     * @param number - Number of a day.
     * @param date - Date of a day.
     * @param dayAccordingToTimetable - Day name according to timetable.
     * @param getDayAccordingToCalendar - Day name according to calendar.
     */
    public Day(int number, String date, String dayAccordingToTimetable, String getDayAccordingToCalendar) {
        this.number = number;
        this.date = date;
        this.dayAccordingToTimetable = dayAccordingToTimetable;
        this.getDayAccordingToCalendar = getDayAccordingToCalendar;
    }

    /**
     * Gets value of date variable.
     * @return Returns value of date variable.
     */
    String getDate() {
        return date;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "Day{" +
                "number=" + number +
                ", date=" + date +
                ", dayAccordingToTimetable='" + dayAccordingToTimetable + '\'' +
                ", getDayAccordingToCalendar='" + getDayAccordingToCalendar + '\'' +
                '}';
    }

}
