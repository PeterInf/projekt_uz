package edu.projectuz.importers.planuz.model.calendars;

import java.util.ArrayList;

public class DaysList {

    private String type;
    private ArrayList<Day> days = new ArrayList<>();

    public DaysList(String type) {
        this.type = type;
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public String getType() {
        return type;
    }

    public Day getDayByDate(String date) {
        for(Day day : days) {
            if(day.getDate().equals(date)) {
                return day;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DaysList{" +
                "type='" + type + '\'' +
                ", days=" + days +
                '}';
    }

}
