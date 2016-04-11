package edu.projectuz.mCal.importers.ical.model;

public class ICalEventAlarm {

    private String action;
    private String alarmDescription;
    private String trigger;

    public ICalEventAlarm(String action, String alarmDescription, String trigger) {
        this.action = action;
        this.alarmDescription = alarmDescription;
        this.trigger = trigger;
    }

    //region ICalEventAlarm Getters and Setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAlarmDescription() {
        return alarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        this.alarmDescription = alarmDescription;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    //endregion
}
