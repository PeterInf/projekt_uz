package edu.projectuz.mCal.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class is a root of timetables model hierarchy that is structured in
 * very similar way to planUz timetables on website.
 * This class stores a list of {@link Department} objects.
 * Instance of this class is returned by
 * {@link DepartmentsListImporter#importDepartments()}.
 */
public class DepartmentsList {

    private ArrayList<Department> departmentsList = new ArrayList<>();

    /**
     * Adds single {@link Department} object to departments list.
     *
     * @param department - {@link Department} object to add.
     */
    public final void addDepartment(final Department department) {
        departmentsList.add(department);
    }

    /**
     * Sets the list of the {@link Department} objects
     * with this given as a parameter.
     *
     * @param aDepartmentsList - {@link Department} objects list to set.
     */
    public final void setDepartmentsList(
            final ArrayList<Department> aDepartmentsList) {
        this.departmentsList = aDepartmentsList;
    }

    /**
     * This function allows you to search for a {@link Department} by it's name.
     * If object wasn't found it throws an exception.
     *
     * @param name - name of the {@link Department} to find.
     * @return Returns {@link Department} object found.
     */
    public final Department getDepartmentByName(
            final String name) throws Exception {
        for (Department department : departmentsList) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        throw new Exception("Department with name \'" + name + "\' not found.");
    }

    /**
     * Gets list of {@link Department} objects.
     *
     * @return Returns list of {@link Department} objects.
     */
    public final ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    /**
     * @return Size of departments list.
     */
    public final int size() {
        return departmentsList.size();
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "DepartmentsList{" + "departmentsList="
                + departmentsList + '}';
    }

}
