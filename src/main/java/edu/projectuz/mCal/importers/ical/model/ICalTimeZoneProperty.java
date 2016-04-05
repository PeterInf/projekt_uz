package edu.projectuz.mCal.importers.ical.model;

/**
 * Created by Sivik on 05-Apr-16.
 */
public class ICalTimeZoneProperty {
    private String nameTimeZone;
    private String timeZoneOffsetFrom;
    private String timeZoneOffsetTo;
    private String timezoneName;
    private String DateTimeStart;
    private String RRule;

    public ICalTimeZoneProperty(String nameTimeZone, String timeZoneOffsetFrom, String timeZoneOffsetTo,
                                String timezoneName, String dateTimeStart, String RRule) {
        this.nameTimeZone = nameTimeZone;
        this.timeZoneOffsetFrom = timeZoneOffsetFrom;
        this.timeZoneOffsetTo = timeZoneOffsetTo;
        this.timezoneName = timezoneName;
        DateTimeStart = dateTimeStart;
        this.RRule = RRule;
    }

    //region ICalTimeZoneProperty Getters and Setters
    public String getNameTimeZone() {
        return nameTimeZone;
    }

    public void setNameTimeZone(String nameTimeZone) {
        this.nameTimeZone = nameTimeZone;
    }

    public String getTimeZoneOffsetFrom() {
        return timeZoneOffsetFrom;
    }

    public void setTimeZoneOffsetFrom(String timeZoneOffsetFrom) {
        this.timeZoneOffsetFrom = timeZoneOffsetFrom;
    }

    public String getTimeZoneOffsetTo() {
        return timeZoneOffsetTo;
    }

    public void setTimeZoneOffsetTo(String timeZoneOffsetTo) {
        this.timeZoneOffsetTo = timeZoneOffsetTo;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public String getDateTimeStart() {
        return DateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        DateTimeStart = dateTimeStart;
    }

    public String getRRule() {
        return RRule;
    }

    public void setRRule(String RRule) {
        this.RRule = RRule;
    }
    //endregion

}
