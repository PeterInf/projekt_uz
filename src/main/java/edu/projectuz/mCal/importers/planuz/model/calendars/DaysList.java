package edu.projectuz.mCal.importers.planuz.model.calendars;

import java.util.ArrayList;

/**
 * This class stores a list of {@link Day} objects of a particular type.
 * It's a part of {@link Calendar} class.
 * Every {@link Calendar} is divided into few groups of days that have
 * a type.
 * For example: planUz calendar called D - Studia stacjonarne has few day types
 * like D, DP, DN...
 */
public class DaysList {

    private String type;
    private ArrayList<Day> days = new ArrayList<>();

    /**
     * Class constructor. Simply sets a value of type variable.
     * @param type - name of days type.
     */
    public DaysList(String type) {
        this.type = type;
    }

    /**
     * Adds single {@link Day} object passed by parameter to the list of days.
     * @param day - {@link Day} object to add.
     */
    public void addDay(Day day) {
        days.add(day);
    }

    /**
     * Get value of type variable.
     * @return Returns value of type variable.
     */
    public String getType() {
        return type;
    }

    /**
     * Get value of days variable.
     * @return Returns list of days.
     */
    public ArrayList<Day> getDays() {
        return days;
    }

    /**
     * This function allows you to search for a day by it's date.
     * If there's no day with this date it throws an exception.
     * @param date - Date of a {@link Day} to find.
     * @return Returns day that has been found.
     */
    public Day getDayByDate(String date) throws Exception {
        for(Day day : days) {
            if(day.getDate().equals(date)) {
                return day;
            }
        }
        throw new Exception("Day with date \'" + date + "\' not found");
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "DaysList{" +
                "type='" + type + '\'' +
                ", days=" + days +
                '}';
    }

}
