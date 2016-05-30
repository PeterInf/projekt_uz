package edu.projectuz.mCal.importers.ical.model;

public class ICalEventAlarm {

    private String action;
    private String alarmDescription;
    private String trigger;

    public ICalEventAlarm(final String anAction,
                          final String anAlarmDescription,
                          final String aTrigger) {
        this.action = anAction;
        this.alarmDescription = anAlarmDescription;
        this.trigger = aTrigger;
    }

    //region ICalEventAlarm Getters and Setters
    public final String getAction() {
        return action;
    }

    public final void setAction(final String anAction) {
        this.action = anAction;
    }

    public final String getAlarmDescription() {
        return alarmDescription;
    }

    public final void setAlarmDescription(final String anAlarmDescription) {
        this.alarmDescription = anAlarmDescription;
    }

    public final String getTrigger() {
        return trigger;
    }

    public final void setTrigger(final String aTrigger) {
        this.trigger = aTrigger;
    }
    //endregion
}
