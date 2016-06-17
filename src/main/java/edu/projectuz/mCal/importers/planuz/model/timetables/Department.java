package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents single planUz department.
 * Instances of this class are stored in {@link DepartmentsList} class.
 * It contains a list of {@link StudyBranch} objects.
 */
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;

    private String name;


    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<StudyBranch> studyBranchList = new ArrayList<>();

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
            final List<StudyBranch> aStudyBranchList) {
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
     * @throws Exception not found study branch.
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
    public final List<StudyBranch> getStudyBranchList() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department() {
    }
}
