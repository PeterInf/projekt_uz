package edu.projectuz.mCal.importers.planuz.model.calendars;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores information about single planUz calendar.
 * It's a part of {@link CalendarsList}.
 * It keeps this information as a list of {@link DaysList} object.
 */
@Entity
public class Calendar {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;

    @OneToMany(cascade={CascadeType.ALL})
    private List<DaysList> daysLists = new ArrayList<>();

    /**
     * Class constructor that simply
     * sets values of name and description variables.
     *
     * @param aName        - name of a Calendar.
     * @param aDescription - description of Calendar.
     */
    public Calendar(final String aName, final String aDescription) {
        this.name = aName;
        this.description = aDescription;
    }

    /**
     * This functions adds a single {@link DaysList} object to the list.
     *
     * @param daysList - {@link DaysList} object to add.
     */
    public final void addDaysList(final DaysList daysList) {
        daysLists.add(daysList);
    }


    /**
     * This function sets a list of {@link DaysList}
     * to this given as a parameter.
     *
     * @param aDaysLists - list of {@link DaysList} objects to set.
     */
    public final void setDaysLists(final ArrayList<DaysList> aDaysLists) {
        this.daysLists = aDaysLists;
    }

    /**
     * This function allows you to search for a particular
     * object of {@link DaysList}
     * by it's type. If there is no object of this type, it throws an exception.
     *
     * @param type - type of {@link DaysList} object to find.
     * @return Returns found {@link DaysList} object.
     */
    public final DaysList getDaysListByType(
            final String type) throws Exception {
        for (DaysList daysList : daysLists) {
            if (daysList.getType().equals(type)) {
                return daysList;
            }
        }
        throw new Exception("Days list of type: \'" + type + "\' not found.");
    }

    /**
     * Gets value of name variable.
     *
     * @return Returns value of name variable.
     */
    public final String getName() {
        return name;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "Calendar{"
                + "name='" + name
                + '\'' + ", description='"
                + description + '\'' + ", daysLists="
                + daysLists + '}';
    }

    public final boolean isContainingDayType(final String dayType) {
        for (DaysList daysList : daysLists) {
            if (daysList.getType().equals(dayType)) {
                return true;
            }
        }
        return false;
    }

    //region Getter/Setter/Constructor(No-Arg)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DaysList> getDaysLists() {
        return daysLists;
    }

    public void setDaysLists(List<DaysList> daysLists) {
        this.daysLists = daysLists;
    }

    public Calendar() {
    }
    //endregion
}
