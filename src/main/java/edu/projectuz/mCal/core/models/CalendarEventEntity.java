package edu.projectuz.mCal.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class stores information about events.
 */
@Entity
public class CalendarEventEntity {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable=false)
    private Date startDate;
    private Date endDate;
    @Column(nullable=false)
    private String title;
    private String description;
    private String tag;
    private TimeZone timeZone;

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
    public CalendarEventEntity(String title, Date startDate, Date endDate, String description, String tag, TimeZone timeZone) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.tag = tag;
        this.timeZone = timeZone;
    }

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return Returned a string representation of the object CalendarEvent.
     */
    @Override
    public String toString() {
        return System.lineSeparator() +
                title +
                startDate +
                endDate +
                description +
                tag +
                timeZone.getID();
    }

    /**
     * This method is needed to make comparing two objects in a class CSVImporterTest.
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj - the reference object with which to compare.
     * @return Returned true if this object is the same as the obj argument, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CalendarEvent that = (CalendarEvent) obj;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        return timeZone != null ? timeZone.equals(that.timeZone) : that.timeZone == null;

    }

    /**
     * This method is needed to make comparing two objects in a class CSVImporterTest.
     *
     * @return Returned a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        return result;
    }
}