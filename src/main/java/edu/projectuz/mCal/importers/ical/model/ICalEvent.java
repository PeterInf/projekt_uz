package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalEvent {
    private String dateTimeStamp;
    private String uid;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String summary;
    private String description;
    private ArrayList<ICalEventAlarm> eventAlarms = new ArrayList<>();

    public ICalEvent(final String aDateTimeStamp, final String anUid,
                     final String aDateTimeStart, final String aDateTimeEnd,
                     final String aSummary, final String aDescription,
                     final ArrayList<ICalEventAlarm> anEventAlarms) {
        this.dateTimeStamp = aDateTimeStamp;
        this.uid = anUid;
        this.dateTimeStart = aDateTimeStart;
        this.dateTimeEnd = aDateTimeEnd;
        this.summary = aSummary;
        this.description = aDescription;
        this.eventAlarms = anEventAlarms;
    }

    //region ICalEvent Getters and Setters
    public final String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public final void setDateTimeStamp(final String aDateTimeStamp) {
        this.dateTimeStamp = aDateTimeStamp;
    }

    public final String getUid() {
        return uid;
    }

    public final void setUid(final String anUid) {
        this.uid = anUid;
    }

    public final String getDateTimeStart() {
        return dateTimeStart;
    }

    public final void setDateTimeStart(final String aDateTimeStart) {
        this.dateTimeStart = aDateTimeStart;
    }

    public final String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public final void setDateTimeEnd(final String aDateTimeEnd) {
        this.dateTimeEnd = aDateTimeEnd;
    }

    public final String getSummary() {
        return summary;
    }

    public final void setSummary(final String aSummary) {
        this.summary = aSummary;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String aDescription) {
        this.description = aDescription;
    }

    public final ArrayList<ICalEventAlarm> getEventAlarms() {
        return eventAlarms;
    }

    public final void setEventAlarms(
            final ArrayList<ICalEventAlarm> anEventAlarms) {
        this.eventAlarms = anEventAlarms;
    }
    //endregion
}
