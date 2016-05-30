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
    private final int magicNumber = 31;

    /**
     * Class constructor that simply sets all
     * of the member variables describing day.
     *
     * @param aNumber                  - Number of a day.
     * @param aDate                    - Date of a day.
     * @param aDayAccordingToTimetable - Day name according to timetable.
     * @param aDayAccordingToCalendar  - Day name according to calendar.
     */
    public Day(final int aNumber, final String aDate,
               final String aDayAccordingToTimetable,
               final String aDayAccordingToCalendar) {
        this.number = aNumber;
        this.date = aDate;
        this.dayAccordingToTimetable = aDayAccordingToTimetable;
        this.dayAccordingToCalendar = aDayAccordingToCalendar;
    }

    /**
     * Gets value of date variable.
     *
     * @return Returns value of date variable.
     */
    public final String getDate() {
        return date;
    }

    /**
     * @return Day name according to calendar.
     */
    public final String getDayAccordingToCalendar() {
        return dayAccordingToCalendar;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "Day{" + "number="
                + number + ", date=" + date
                + ", dayAccordingToTimetable='"
                + dayAccordingToTimetable + '\''
                + ", dayAccordingToCalendar='"
                + dayAccordingToCalendar + '\'' + '}';
    }

    @Override
    public final int hashCode() {
        int result = number;
        result = magicNumber * result + (date != null ? date.hashCode() : 0);
        result = magicNumber * result + (dayAccordingToTimetable != null
                ? dayAccordingToTimetable.hashCode() : 0);
        result = magicNumber * result + (dayAccordingToCalendar != null
                ? dayAccordingToCalendar.hashCode() : 0);
        return result;
    }

    /**
     * Compares one object to another
     *
     * @param o - object to compare with
     * @return returns true if object are equal, if not then returns false
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day day = (Day) o;

        if (number != day.number) {
            return false;
        }
        if (date != null ? !date.equals(day.date) : day.date != null) {
            return false;
        }
        if (dayAccordingToTimetable != null ? !dayAccordingToTimetable.
                equals(day.dayAccordingToTimetable)
                : day.dayAccordingToTimetable != null) {
            return false;
        }
        return dayAccordingToCalendar != null ? dayAccordingToCalendar.
                equals(day.dayAccordingToCalendar)
                : day.dayAccordingToCalendar == null;
    }

}
