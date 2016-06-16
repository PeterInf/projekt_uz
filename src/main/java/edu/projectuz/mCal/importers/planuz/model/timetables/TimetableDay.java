package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a single day of a planUz timetable.
 * It stores a list of {@link TimetableEvent} objects, that are classes,
 * exams or anything else that is written on a timetable.
 * Instances of this class are stored in {@link GroupTimetable} class.
 */
@Entity
public class TimetableDay {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<TimetableEvent> eventsList = new ArrayList<>();

    public TimetableDay() {}

    /**
     * Class constructor that sets name of a day.
     * @param aName - name of a day to set.
     */
    public TimetableDay(final String aName) {
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
    public final List<TimetableEvent> getEventsList() {
        return eventsList;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "TimetableDay{"
                + "name='" + name + '\''
                + ", eventsList=" + eventsList + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
