package edu.projectuz.mCal.importers.planuz.model.calendars;

import java.util.ArrayList;

/**
 * This class stores information about single planUz calendar.
 * It's a part of {@link CalendarsList}.
 * It keeps this information as a list of {@link DaysList} object.
 */
public class Calendar {

    private String name;
    private String description;

    private ArrayList<DaysList> daysLists = new ArrayList<>();

    /**
     * Class constructor that simply sets values of name and description variables.
     * @param name - name of a Calendar.
     * @param description - description of Calendar.
     */
    public Calendar(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * This functions adds a single {@link DaysList} object to the list.
     * @param daysList - {@link DaysList} object to add.
     */
    public void addDaysList(DaysList daysList) {
        daysLists.add(daysList);
    }


    /**
     * This function sets a list of {@link DaysList} to this given as a parameter.
     * @param daysLists - list of {@link DaysList} objects to set.
     */
    public void setDaysLists(ArrayList<DaysList> daysLists) {
        this.daysLists = daysLists;
    }

    /**
     * This function allows you to search for a particular object of {@link DaysList}
     * by it's type. If there is no object of this type, it throws an exception.
     * @param type - type of {@link DaysList} object to find.
     * @return Returns found {@link DaysList} object.
     */
    public DaysList getDaysListByType(String type) throws Exception {
        for(DaysList daysList : daysLists) {
            if(daysList.getType().equals(type)) {
                return daysList;
            }
        }
        throw new Exception("Days list of type: \'" + type + "\' not found.");
    }

    /**
     * Gets value of name variable.
     * @return Returns value of name variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "Calendar{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", daysLists=" + daysLists +
                '}';
    }

}
