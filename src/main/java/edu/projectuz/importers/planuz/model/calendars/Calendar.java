package edu.projectuz.importers.planuz.model.calendars;

import java.util.ArrayList;

public class Calendar {

    private String name;
    private String description;

    private ArrayList<DaysList> daysLists = new ArrayList<>();

    public Calendar(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addDaysList(DaysList daysList) {
        daysLists.add(daysList);
    }

    public DaysList getDaysListByType(String type) {
        for(DaysList daysList : daysLists) {
            if(daysList.getType().equals(type)) {
                return daysList;
            }
        }
        return null;
    }

    public void setDaysLists(ArrayList<DaysList> daysLists) {
        this.daysLists = daysLists;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", daysLists=" + daysLists +
                '}';
    }

}
