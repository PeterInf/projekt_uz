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
    private String dayAccordingToCalendar;

    /**
     * Class constructor that simply sets all of the member variables describing day.
     * @param number - Number of a day.
     * @param date - Date of a day.
     * @param dayAccordingToTimetable - Day name according to timetable.
     * @param dayAccordingToCalendar - Day name according to calendar.
     */
    public Day(int number, String date, String dayAccordingToTimetable, String dayAccordingToCalendar) {
        this.number = number;
        this.date = date;
        this.dayAccordingToTimetable = dayAccordingToTimetable;
        this.dayAccordingToCalendar = dayAccordingToCalendar;
    }

    /**
     * Gets value of date variable.
     * @return Returns value of date variable.
     */
    public String getDate() {
        return date;
    }

    /**
     * @return Day name according to calendar.
     */
    public String getDayAccordingToCalendar() {
        return dayAccordingToCalendar;
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
                ", dayAccordingToCalendar='" + dayAccordingToCalendar + '\'' +
                '}';
    }

    /**
     * Compares one object to another
     * @param o - object to compare with
     * @return returns true if object are equal, if not then returns false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day day = (Day) o;

        if (number != day.number) return false;
        if (date != null ? !date.equals(day.date) : day.date != null) return false;
        if (dayAccordingToTimetable != null ? !dayAccordingToTimetable.equals(day.dayAccordingToTimetable) : day.dayAccordingToTimetable != null)
            return false;
        return dayAccordingToCalendar != null ? dayAccordingToCalendar.equals(day.dayAccordingToCalendar) : day.dayAccordingToCalendar == null;

    }

}
