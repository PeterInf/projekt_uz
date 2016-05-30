package edu.projectuz.mCal.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class represents a single branch of study from planUz.
 * Object of this class are stored in {@link Department} class.
 * The class itself stores all groups of particular branch of study
 * in a list of {@link GroupTimetable} objects.
 */
public class StudyBranch {

    private String name;

    private ArrayList<GroupTimetable> groupTimetablesList = new ArrayList<>();

    /**
     * Class constructor. Sets branch of study name.
     *
     * @param aName - name to set.
     */
    public StudyBranch(final String aName) {
        this.name = aName;
    }

    /**
     * Adds single group to ths list.
     *
     * @param groupTimetable - {@link GroupTimetable} object to add.
     */
    public final void addGroupTimetable(final GroupTimetable groupTimetable) {
        groupTimetablesList.add(groupTimetable);
    }

    /**
     * Sets the list of all groups to this given as a parameter.
     *
     * @param aGroupTimetablesList - list of {@link GroupTimetable}
     *                             objects to set.
     */
    public final void setGroupTimetablesList(
            final ArrayList<GroupTimetable> aGroupTimetablesList) {
        this.groupTimetablesList = aGroupTimetablesList;
    }

    /**
     * Gets name of the branch of study.
     *
     * @return Returns branch of study name.
     */
    public final String getName() {
        return name;
    }

    /**
     * This function allows you to search for a single group by it's name.
     * If nothing was found it throws an exception.
     *
     * @param aName - name of a {@link GroupTimetable} to find.
     * @return Returns found {@link GroupTimetable} object.
     */
    public final GroupTimetable getGroupTimetableByName(
            final String aName) throws Exception {
        for (GroupTimetable groupTimetable : groupTimetablesList) {
            if (groupTimetable.getName().equals(aName)) {
                return groupTimetable;
            }
        }
        throw new Exception("Group timetable with name \'"
                + aName + "\' not found.");
    }

    /**
     * Gets a list of every group.
     *
     * @return Returns a list of {@link GroupTimetable} objects.
     */
    public final ArrayList<GroupTimetable> getGroupTimetablesList() {
        return groupTimetablesList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "StudyBranch{" + "name='" + name + '\''
                + ", groupTimetablesList="
                + groupTimetablesList + '}';
    }
}
