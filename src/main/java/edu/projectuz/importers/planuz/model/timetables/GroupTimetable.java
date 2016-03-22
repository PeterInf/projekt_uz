package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

public class GroupTimetable {

    private String name;
    private ArrayList<Day> daysList = new ArrayList<>();

    public GroupTimetable(String name) {
        this.name = name;
    }

    public void addDay(Day day) {
        daysList.add(day);
    }

    public void setDaysList(ArrayList<Day> daysList) {
        this.daysList = daysList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Day> getDaysList() {
        return daysList;
    }

    public Day getDayByName(String name) {
        for(Day day : daysList) {
            if(day.getName().equals(name)) {
                return day;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GroupTimetable{" +
                "name='" + name + '\'' +
                ", daysList=" + daysList +
                '}';
    }

}
