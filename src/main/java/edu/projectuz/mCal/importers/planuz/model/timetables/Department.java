package edu.projectuz.mCal.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class represents single planUz department.
 * Instances of this class are stored in {@link DepartmentsList} class.
 * It contains a list of {@link StudyBranch} objects.
 */
public class Department {

    private String name;
    private ArrayList<StudyBranch> studyBranchList = new ArrayList<>();

    /**
     * Class constructor. Simply sets a value of name variable.
     *
     * @param aName - name of department to set.
     */
    public Department(final String aName) {
        this.name = aName;
    }

    /**
     * Adds single {@link StudyBranch} object to the list.
     *
     * @param studyBranch - {@link StudyBranch} object to add.
     */
    public final void addStudyBranch(final StudyBranch studyBranch) {
        studyBranchList.add(studyBranch);
    }

    /**
     * Sets list of {@link StudyBranch} to this given as a parameter.
     *
     * @param aStudyBranchList - list of {@link StudyBranch} objects to set.
     */
    public final void setStudyBranchList(
            final ArrayList<StudyBranch> aStudyBranchList) {
        this.studyBranchList = aStudyBranchList;
    }

    /**
     * Gets department's name.
     *
     * @return Returns value of name variable.
     */
    public final String getName() {
        return name;
    }

    /**
     * This function allows you to search
     * for a {@link StudyBranch} object by it's name.
     * If object wasn't found it throws an exception.
     *
     * @param aName - name of {@link StudyBranch} to find.
     * @return Returns {@link StudyBranch} object that was found.
     */
    public final StudyBranch getStudyBranchByName(
            final String aName) throws Exception {
        for (StudyBranch studyBranch : studyBranchList) {
            if (studyBranch.getName().equals(aName)) {
                return studyBranch;
            }
        }
        throw new Exception("Study branch with name \'"
                + aName + "\' not found.");
    }

    /**
     * Gets all study branches from this department.
     *
     * @return Returns a list of {@link StudyBranch} objects.
     */
    public final ArrayList<StudyBranch> getStudyBranchList() {
        return studyBranchList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "Department{" + "name='"
                + name + '\'' + ", studyBranchList="
                + studyBranchList + '}';
    }
}
