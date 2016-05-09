package edu.projectuz.mCal.web;

import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

public class AddEventForm {

    @NotNull
    private DateTime startDate;
    @NotNull
    private DateTime endDate;
    @NotNull
    @Size(min = 5, max = 16)
    private String title;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @Size(min = 5, max = 16)
    private String tag;
    @NotNull
    private TimeZone timeZone;

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
