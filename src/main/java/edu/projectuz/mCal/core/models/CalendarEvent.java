package edu.projectuz.mCal.core.models;

import edu.projectuz.mCal.helpers.DateHelper;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

/**
 * This class stores information about events.
 */
@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue
    private int id;

    @NotNull @Size(min=1, max=25, message="Title should contain 1-25 characters")
    private String title;

    @NotNull(message="Wrong date format")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startDate;

    @NotNull(message="Wrong date format")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endDate;

    @NotNull @Size(min=1, max=25, message="Tag should contain 1-25 characters")
    private String tag;

    @NotNull
    private TimeZone timeZone;

    @NotNull @Size(min=1, message="Description should contain at least 1 character")
    private String description;

    @Transient
    private final int hashCode = 31;

    /**
     * Default constructor takes to create an object in CSVImporter class.
     */
    public CalendarEvent() {
    }

    /**
     * The constructor needed for the test class.
     *
     * @param title       - event name.
     * @param startDate   - start time of the events.
     * @param endDate     - end date of the events.
     * @param description - description of events.
     * @param tag         - tag of events.
     * @param timeZone    - time zone of events.
     */
    public CalendarEvent(final String title, final DateTime startDate,
                         final DateTime endDate, final String description,
                         final String tag, final TimeZone timeZone) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.tag = tag;
        this.timeZone = timeZone;
    }

    public final DateTime getStartDate() {
        return startDate;
    }

    public final void setStartDate(final DateTime aStartDate) {
        this.startDate = aStartDate;
    }

    public final void setStartDate(final String startDate) {
        this.startDate = DateHelper.stringToDate(startDate, "dd-mm-yyyy HH:mm:ss",
                TimeZone.getTimeZone("America/Los_Angeles"));
    }

    public final DateTime getEndDate() {
        return endDate;
    }

    public final void setEndDate(final DateTime anEndDate) {
        this.endDate = anEndDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = DateHelper.stringToDate(endDate, "dd-mm-yyyy HH:mm:ss",
                TimeZone.getTimeZone("America/Los_Angeles"));
    }

    public int getId() {
        return id;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String aDescription) {
        this.description = aDescription;
    }

    public final String getTag() {
        return tag;
    }

    public final void setTag(final String aTag) {
        this.tag = aTag;
    }

    public final TimeZone getTimeZone() {
        return timeZone;
    }

    public final void setTimeZone(final TimeZone aTimeZone) {
        this.timeZone = aTimeZone;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String aTitle) {
        this.title = aTitle;
    }

    /**
     * @return Returned a string representation of the object CalendarEvent.
     */
    @Override
    public final String toString() {
        return System.lineSeparator()
                + title
                + startDate
                + endDate
                + description
                + tag
                + timeZone.getID();
    }

    /**
     * This method is needed to make comparing
     * two objects in a class CSVImporterTest.
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj - the reference object with which to compare.
     * @return Returned true if this object is the same
     * as the obj argument, false otherwise.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CalendarEvent that = (CalendarEvent) obj;

        if (startDate != null ? !startDate.equals(that.startDate)
                : that.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(that.endDate)
                : that.endDate != null) {
            return false;
        }
        if (title != null ? !title.equals(that.title)
                : that.title != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description)
                : that.description != null) {
            return false;
        }
        if (tag != null ? !tag.equals(that.tag)
                : that.tag != null) {
            return false;
        }
        return timeZone != null ? timeZone.equals(that.timeZone)
                : that.timeZone == null;
    }

    /**
     * This method is needed to make comparing
     * two objects in a class CSVImporterTest.
     *
     * @return Returned a hash code value for the object.
     */
    @Override
    public final int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = hashCode * result
                + (endDate != null ? endDate.hashCode() : 0);
        result = hashCode * result + (title != null ? title.hashCode() : 0);
        result = hashCode * result
                + (description != null ? description.hashCode() : 0);
        result = hashCode * result
                + (tag != null ? tag.hashCode() : 0);
        result = hashCode * result
                + (timeZone != null ? timeZone.hashCode() : 0);
        return result;
    }
}
