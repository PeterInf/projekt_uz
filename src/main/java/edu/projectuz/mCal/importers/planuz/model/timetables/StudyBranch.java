package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a single branch of study from planUz.
 * Object of this class are stored in {@link Department} class.
 * The class itself stores all groups of particular branch of study
 * in a list of {@link GroupTimetable} objects.
 */
@Entity
public class StudyBranch {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<GroupTimetable> groupTimetablesList = new ArrayList<>();


    public StudyBranch() {}

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
            final List<GroupTimetable> aGroupTimetablesList) {
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
    public final List<GroupTimetable> getGroupTimetablesList() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
