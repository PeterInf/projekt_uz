package edu.projectuz.mCal.importers.ical.model;

public class ICalEventAlarm {

    private String Action;
    private String AlarmDescription;
    private String Trigger;

    public ICalEventAlarm(String action, String alarmDescription, String trigger) {
        Action = action;
        AlarmDescription = alarmDescription;
        Trigger = trigger;
    }

    //region ICalEventAlarm Getters and Setters
    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getAlarmDescription() {
        return AlarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        AlarmDescription = alarmDescription;
    }

    public String getTrigger() {
        return Trigger;
    }

    public void setTrigger(String trigger) {
        Trigger = trigger;
    }
    //endregion
}
