package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

public class Day {

    private String name;
    private ArrayList<TimetableEvent> eventsList = new ArrayList<>();

    public Day(String name) {
        this.name = name;
    }

    public void addEvent(TimetableEvent timetableEvent) {
        eventsList.add(timetableEvent);
    }

    public void setEventsList(ArrayList<TimetableEvent> classesList) {
        this.eventsList = classesList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<TimetableEvent> getEventsList() {
        return eventsList;
    }

    @Override
    public String toString() {
        return "Day{" +
                "name='" + name + '\'' +
                ", eventsList=" + eventsList +
                '}';
    }

}
