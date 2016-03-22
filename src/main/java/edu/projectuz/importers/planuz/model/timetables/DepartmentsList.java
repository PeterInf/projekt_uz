package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

public class DepartmentsList {

    private ArrayList<Department> departmentsList = new ArrayList<>();

    public void addDepartment(Department department) {
        departmentsList.add(department);
    }

    public void setDepartmentsList(ArrayList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public Department getDepartmentByName(String name) {
        for(Department department : departmentsList) {
            if(department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    @Override
    public String toString() {
        return "DepartmentsList{" +
                "departmentsList=" + departmentsList +
                '}';
    }
}
