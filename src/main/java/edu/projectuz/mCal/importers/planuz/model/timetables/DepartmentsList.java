package edu.projectuz.mCal.importers.planuz.model.timetables;

import edu.projectuz.mCal.importers.planuz.logic.timetables.TimetablesImporter;

import java.util.ArrayList;

/**
 * This class is a root of timetables model hierarchy that is structured in
 * very similar way to planUz timetables on website.
 * This class stores a list of {@link Department} objects.
 * Instance of this class is returned by
 * {@link TimetablesImporter#importTimetables()}.
 */
public class DepartmentsList {

    private ArrayList<Department> departmentsList = new ArrayList<>();

    /**
     * Adds single {@link Department} object to departments list.
     * @param department - {@link Department} object to add.
     */
    public void addDepartment(Department department) {
        departmentsList.add(department);
    }

    /**
     * Sets the list of the {@link Department} objects with this given as a parameter.
     * @param departmentsList - {@link Department} objects list to set.
     */
    public void setDepartmentsList(ArrayList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    /**
     * This function allows you to search for a {@link Department} by it's name.
     * If object wasn't found it throws an exception.
     * @param name - name of the {@link Department} to find.
     * @return Returns {@link Department} object found.
     */
    public Department getDepartmentByName(String name) throws Exception {
        for(Department department : departmentsList) {
            if(department.getName().equals(name)) {
                return department;
            }
        }
        throw new Exception("Department with name \'" + name + "\' not found.");
    }

    /**
     * Gets list of {@link Department} objects.
     * @return Returns list of {@link Department} objects.
     */
    public ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "DepartmentsList{" +
                "departmentsList=" + departmentsList +
                '}';
    }
}
