package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

public class Major {

    private String name;

    private ArrayList<GroupTimetable> groupTimetablesList = new ArrayList<>();

    public Major(String name) {
        this.name = name;
    }

    public void addGroupTimetable(GroupTimetable groupTimetable) {
        groupTimetablesList.add(groupTimetable);
    }

    public void setGroupTimetablesList(ArrayList<GroupTimetable> groupTimetablesList) {
        this.groupTimetablesList = groupTimetablesList;
    }

    public String getName() {
        return name;
    }

    public GroupTimetable getGroupTimetableByName(String name) {
        for(GroupTimetable groupTimetable : groupTimetablesList) {
            if(groupTimetable.getName().equals(name)) {
                return groupTimetable;
            }
        }
        return null;
    }

    public ArrayList<GroupTimetable> getGroupTimetablesList() {
        return groupTimetablesList;
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                ", groupTimetablesList=" + groupTimetablesList +
                '}';
    }

}
