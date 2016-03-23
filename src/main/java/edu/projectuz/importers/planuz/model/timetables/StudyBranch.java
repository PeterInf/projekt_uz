package edu.projectuz.importers.planuz.model.timetables;

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
     * @param name - name to set.
     */
    public StudyBranch(String name) {
        this.name = name;
    }

    /**
     * Adds single group to ths list.
     * @param groupTimetable - {@link GroupTimetable} object to add.
     */
    public void addGroupTimetable(GroupTimetable groupTimetable) {
        groupTimetablesList.add(groupTimetable);
    }

    /**
     * Sets the list of all groups to this given as a parameter.
     * @param groupTimetablesList - list of {@link GroupTimetable} objects to set.
     */
    public void setGroupTimetablesList(ArrayList<GroupTimetable> groupTimetablesList) {
        this.groupTimetablesList = groupTimetablesList;
    }

    /**
     * Gets name of the branch of study.
     * @return Returns branch of study name.
     */
    public String getName() {
        return name;
    }

    /**
     * This function allows you to search for a single group by it's name.
     * @param name - name of a {@link GroupTimetable} to find.
     * @return Returns found {@link GroupTimetable} object.
     * If nothing was found it returns null.
     */
    public GroupTimetable getGroupTimetableByName(String name) {
        for(GroupTimetable groupTimetable : groupTimetablesList) {
            if(groupTimetable.getName().equals(name)) {
                return groupTimetable;
            }
        }
        return null;
    }

    /**
     * Gets a list of every group.
     * @return Returns a list of {@link GroupTimetable} objects.
     */
    public ArrayList<GroupTimetable> getGroupTimetablesList() {
        return groupTimetablesList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "StudyBranch{" +
                "name='" + name + '\'' +
                ", groupTimetablesList=" + groupTimetablesList +
                '}';
    }

}
