package edu.projectuz.importers.planuz.model.timetables;

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
     * @param name - name of department to set.
     */
    public Department(String name) {
        this.name = name;
    }

    /**
     * Adds single {@link StudyBranch} object to the list.
     * @param studyBranch - {@link StudyBranch} object to add.
     */
    public void addStudyBranch(StudyBranch studyBranch) {
        studyBranchList.add(studyBranch);
    }

    /**
     * Sets list of {@link StudyBranch} to this given as a parameter.
     * @param studyBranchList - list of {@link StudyBranch} objects to set.
     */
    public void setStudyBranchList(ArrayList<StudyBranch> studyBranchList) {
        this.studyBranchList = studyBranchList;
    }

    /**
     * Gets department's name.
     * @return Returns value of name variable.
     */
    public String getName() {
        return name;
    }

    /**
     * This function allows you to search for a {@link StudyBranch} object by it's name.
     * @param name - name of {@link StudyBranch} to find.
     * @return Returns {@link StudyBranch} object that was found. If it wasn't
     * it returns null.
     */
    public StudyBranch getStudyBranchByName(String name) {
        for(StudyBranch studyBranch : studyBranchList) {
            if(studyBranch.getName().equals(name)) {
                return studyBranch;
            }
        }

        return null;
    }

    /**
     * Gets all study branches from this department.
     * @return Returns a list of {@link StudyBranch} objects.
     */
    public ArrayList<StudyBranch> getStudyBranchList() {
        return studyBranchList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", studyBranchList=" + studyBranchList +
                '}';
    }

}
