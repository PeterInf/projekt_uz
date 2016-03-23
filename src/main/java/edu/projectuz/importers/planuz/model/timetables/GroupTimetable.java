package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class stores a timetable for one group of specific {@link StudyBranch} from planUz.
 * List of this class instances is stored in {@link Department} class.
 * The class itself stores every day of planUz timetable it is
 * represented by a list of {@link Day} objects.
 */
public class GroupTimetable {

    private String name;
    private ArrayList<Day> daysList = new ArrayList<>();

    /**
     * Class constructor. Simply sets name of a group.
     * @param name - name of group to set.
     */
    public GroupTimetable(String name) {
        this.name = name;
    }

    /**
     * Adds single day to a list.
     * @param day - {@link Day} object to add.
     */
    public void addDay(Day day) {
        daysList.add(day);
    }

    /**
     * Sets list of days for this passed by a parameter.
     * @param daysList - list of {@link Day} objects to set.
     */
    public void setDaysList(ArrayList<Day> daysList) {
        this.daysList = daysList;
    }

    /**
     * Gets name of a group.
     * @return Returns value of name variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets every day in group.
     * @return Returns list of {@link Day} objects.
     */
    public ArrayList<Day> getDaysList() {
        return daysList;
    }

    /**
     * This function allows you to search for a day by it's name.
     * @param name - name of {@link Day} to find.
     * @return Returns found {@link Day} object. If nothing was found
     * then returns null.
     */
    public Day getDayByName(String name) {
        for(Day day : daysList) {
            if(day.getName().equals(name)) {
                return day;
            }
        }
        return null;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "GroupTimetable{" +
                "name='" + name + '\'' +
                ", daysList=" + daysList +
                '}';
    }

}
