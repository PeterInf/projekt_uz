package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalEvent {
    private String dateTimeStamp;
    private String UID;
    private String DateTimeStart;
    private String DateTimeEnd;
    private String Summary;
    private String Description;
    private ArrayList <ICalEventAlarm> EventAlarms = new ArrayList<>();

    public ICalEvent(String dateTimeStamp, String UID, String dateTimeStart, String dateTimeEnd,
                     String summary, String description, ArrayList<ICalEventAlarm> eventAlarms) {
        this.dateTimeStamp = dateTimeStamp;
        this.UID = UID;
        DateTimeStart = dateTimeStart;
        DateTimeEnd = dateTimeEnd;
        Summary = summary;
        Description = description;
        EventAlarms = eventAlarms;
    }

    //region ICalEvent Getters and Setters
    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(String dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getDateTimeStart() {
        return DateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        DateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return DateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        DateTimeEnd = dateTimeEnd;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<ICalEventAlarm> getEventAlarms() {
        return EventAlarms;
    }

    public void setEventAlarms(ArrayList<ICalEventAlarm> eventAlarms) {
        EventAlarms = eventAlarms;
    }
    //endregion
}
