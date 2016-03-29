package edu.projectuz.importers.planuz.model.timetables;

import java.util.ArrayList;

/**
 * This class represents a single day of a planUz timetable.
 * It stores a list of {@link TimetableEvent} objects, that are classes,
 * exams or anything else that is written on a timetable.
 * Instances of this class are stored in {@link GroupTimetable} class.
 */
public class Day {

    private String name;
    private ArrayList<TimetableEvent> eventsList = new ArrayList<>();

    /**
     * Class constructor that sets name of a day.
     * @param name - name of a day to set.
     */
    public Day(String name) {
        this.name = name;
    }

    /**
     * Adds single event passed as a parameter to this particular day.
     * @param timetableEvent - {@link TimetableEvent} object to add to the list.
     */
    public void addEvent(TimetableEvent timetableEvent) {
        eventsList.add(timetableEvent);
    }

    /**
     * Sets list of every event with this given as a parameter.
     * @param eventsList - list of {@link TimetableEvent} objects to set.
     */
    public void setEventsList(ArrayList<TimetableEvent> eventsList) {
        this.eventsList = eventsList;
    }

    /**
     * Gets a name of a day.
     * @return Returns value of name variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets list of all events.
     * @return Returns a list of {@link TimetableEvent} objects.
     */
    public ArrayList<TimetableEvent> getEventsList() {
        return eventsList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "Day{" +
                "name='" + name + '\'' +
                ", eventsList=" + eventsList +
                '}';
    }

}
