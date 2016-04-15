package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalEvent {
    private String dateTimeStamp;
    private String uid;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String summary;
    private String description;
    private ArrayList <ICalEventAlarm> eventAlarms = new ArrayList<>();

    public ICalEvent(String dateTimeStamp, String uid, String dateTimeStart, String dateTimeEnd,
                     String summary, String description, ArrayList<ICalEventAlarm> eventAlarms) {
        this.dateTimeStamp = dateTimeStamp;
        this.uid = uid;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.summary = summary;
        this.description = description;
        this.eventAlarms = eventAlarms;
    }

    //region ICalEvent Getters and Setters
    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(String dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ICalEventAlarm> getEventAlarms() {
        return eventAlarms;
    }

    public void setEventAlarms(ArrayList<ICalEventAlarm> eventAlarms) {
        this.eventAlarms = eventAlarms;
    }
    //endregion
}
