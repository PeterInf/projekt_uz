package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

public class Department {

    private String name;
    private ArrayList<Major> majorsList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addMajor(Major major) {
        majorsList.add(major);
    }

    public void setMajorsList(ArrayList<Major> majorsList) {
        this.majorsList = majorsList;
    }

    public String getName() {
        return name;
    }

    public Major getMajorByName(String name) {
        for(Major major : majorsList) {
            if(major.getName().equals(name)) {
                return major;
            }
        }

        return null;
    }

    public ArrayList<Major> getMajorsList() {
        return majorsList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", majorsList=" + majorsList +
                '}';
    }

}
