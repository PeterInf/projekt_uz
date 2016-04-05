package edu.projectuz.mCal.core.models;

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

    private Date startDate;
    private Date endDate;
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

}