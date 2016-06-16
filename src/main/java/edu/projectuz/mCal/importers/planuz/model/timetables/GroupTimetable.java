package edu.projectuz.mCal.importers.planuz.model.timetables;

import edu.projectuz.mCal.importers.planuz.model.calendars.Day;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores a timetable for one group
 * of specific {@link StudyBranch} from planUz.
 * List of this class instances is stored in {@link Department} class.
 * The class itself stores every timetableDay of planUz timetable it is
 * represented by a list of {@link TimetableDay} objects.
 */
@Entity
public class GroupTimetable {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<TimetableDay> daysList = new ArrayList<>();

    public GroupTimetable() {}

    /**
     * Class constructor. Simply sets name of a group.
     *
     * @param aName - name of group to set.
     */
    public GroupTimetable(final String aName) {
        this.name = aName;
    }

    /**
     * Adds single timetableDay to a list.
     *
     * @param timetableDay - {@link TimetableDay} object to add.
     */
    public final void addDay(final TimetableDay timetableDay) {
        daysList.add(timetableDay);
    }

    /**
     * Sets list of days for this passed by a parameter.
     *
     * @param aDaysList - list of {@link TimetableDay} objects to set.
     */
    public final void setDaysList(final ArrayList<TimetableDay> aDaysList) {
        this.daysList = aDaysList;
    }

    /**
     * Gets name of a group.
     *
     * @return Returns value of name variable.
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets every timetableDay in group.
     *
     * @return Returns list of {@link TimetableDay} objects.
     */
    public final List<TimetableDay> getDaysList() {
        return daysList;
    }

    /**
     * This function allows you to search for a timetableDay by it's name.
     * If nothing was found then throws an exception.
     *
     * @param aName - name of {@link Day} to find.
     * @return Returns found {@link Day} object.
     * @throws Exception not found day.
     */
    public final TimetableDay getDayByName(final String aName) throws Exception {
        for (TimetableDay timetableDay : daysList) {
            if (timetableDay.getName().equals(aName)) {
                return timetableDay;
            }
        }
        throw new Exception("TimetableDay with name \'" + aName + "\' not found.");
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "GroupTimetable{" + "name='" + name
                + '\'' + ", daysList=" + daysList + '}';
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
