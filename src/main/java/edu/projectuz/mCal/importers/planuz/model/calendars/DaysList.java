package edu.projectuz.mCal.importers.planuz.model.calendars;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores a list of {@link Day} objects of a particular type.
 * It's a part of {@link Calendar} class.
 * Every {@link Calendar} is divided into few groups of days that have
 * a type.
 * For example: planUz calendar called D - Studia stacjonarne has few day types
 * like D, DP, DN...
 */
@Entity
public class DaysList {
    @Id
    @GeneratedValue
    private int id;
    private String type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Day> days = new ArrayList<>() ;

    /**
     * Class constructor. Simply sets a value of type variable.
     *
     * @param aType - name of days type.
     */
    public DaysList(final String aType) {
        this.type = aType;
    }

    /**
     * Adds single {@link Day} object passed by parameter to the list of days.
     *
     * @param day - {@link Day} object to add.
     */
    public final void addDay(final Day day) {
        days.add(day);
    }

    /**
     * Get value of type variable.
     *
     * @return Returns value of type variable.
     */
    public final String getType() {
        return type;
    }

    /**
     * Get value of days variable.
     *
     * @return Returns list of days.
     */
    public final List<Day> getDays() {
        return days;
    }

    /**
     * This function allows you to search for a day by it's date.
     * If there's no day with this date it throws an exception.
     *
     * @param date - Date of a {@link Day} to find.
     * @return Returns day that has been found.
     * @throws Exception not found day.
     */
    public final Day getDayByDate(final String date) throws Exception {
        for (Day day : days) {
            if (day.getDate().equals(date)) {
                return day;
            }
        }
        throw new Exception("Day with date \'" + date + "\' not found");
    }

    /**
     * @return Size of days list
     */
    public final int size() {
        return days.size();
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "DaysList{" + "type='"
                + type + '\'' + ", days="
                + days + '}';
    }

    //region Getter/Setter/Constructor(No-Arg)
    public DaysList() {
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int anId) {
        this.id = anId;
    }

    public final void setType(final String aType) {
        this.type = aType;
    }

    public final void setDays(final List<Day> aDays) {
        this.days = aDays;
    }
    //endregion
}
