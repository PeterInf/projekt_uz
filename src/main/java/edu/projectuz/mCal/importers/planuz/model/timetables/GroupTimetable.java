package edu.projectuz.mCal.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class stores a timetable for one group
 * of specific {@link StudyBranch} from planUz.
 * List of this class instances is stored in {@link Department} class.
 * The class itself stores every day of planUz timetable it is
 * represented by a list of {@link Day} objects.
 */
public class GroupTimetable {

    private String name;
    private ArrayList<Day> daysList = new ArrayList<>();

    /**
     * Class constructor. Simply sets name of a group.
     *
     * @param aName - name of group to set.
     */
    public GroupTimetable(final String aName) {
        this.name = aName;
    }

    /**
     * Adds single day to a list.
     *
     * @param day - {@link Day} object to add.
     */
    public final void addDay(final Day day) {
        daysList.add(day);
    }

    /**
     * Sets list of days for this passed by a parameter.
     *
     * @param aDaysList - list of {@link Day} objects to set.
     */
    public final void setDaysList(final ArrayList<Day> aDaysList) {
        this.daysList = aDaysList;
    }

    /**
     * Gets name of a group.
     *
     * @return Returns value of name variable.
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets every day in group.
     *
     * @return Returns list of {@link Day} objects.
     */
    public final ArrayList<Day> getDaysList() {
        return daysList;
    }

    /**
     * This function allows you to search for a day by it's name.
     * If nothing was found then throws an exception.
     *
     * @param aName - name of {@link Day} to find.
     * @return Returns found {@link Day} object.
     */
    public final Day getDayByName(final String aName) throws Exception {
        for (Day day : daysList) {
            if (day.getName().equals(aName)) {
                return day;
            }
        }
        throw new Exception("Day with name \'" + aName + "\' not found.");
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "GroupTimetable{" + "name='" + name
                + '\'' + ", daysList=" + daysList + '}';
    }

}
