package edu.projectuz.mCal.importers.planuz.model.timetables;

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
     * @param aName - name of a day to set.
     */
    public Day(final String aName) {
        this.name = aName;
    }

    /**
     * Adds single event passed as a parameter to this particular day.
     * @param timetableEvent - {@link TimetableEvent} object to add to the list.
     */
    public final void addEvent(final TimetableEvent timetableEvent) {
        eventsList.add(timetableEvent);
    }

    /**
     * Sets list of every event with this given as a parameter.
     * @param anEventsList - list of {@link TimetableEvent} objects to set.
     */
    public final void setEventsList(
            final ArrayList<TimetableEvent> anEventsList) {
        this.eventsList = anEventsList;
    }

    /**
     * Gets a name of a day.
     * @return Returns value of name variable.
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets list of all events.
     * @return Returns a list of {@link TimetableEvent} objects.
     */
    public final ArrayList<TimetableEvent> getEventsList() {
        return eventsList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "Day{"
                + "name='" + name + '\''
                + ", eventsList=" + eventsList + '}';
    }

}
