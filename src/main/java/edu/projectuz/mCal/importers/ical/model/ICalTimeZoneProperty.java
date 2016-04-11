package edu.projectuz.mCal.importers.ical.model;

public class ICalTimeZoneProperty {
    private String nameTimeZone;
    private String timeZoneOffsetFrom;
    private String timeZoneOffsetTo;
    private String timezoneName;
    private String dateTimeStart;
    private String rRule;

    public ICalTimeZoneProperty(String nameTimeZone, String timeZoneOffsetFrom, String timeZoneOffsetTo,
                                String timezoneName, String dateTimeStart, String rRule) {
        this.nameTimeZone = nameTimeZone;
        this.timeZoneOffsetFrom = timeZoneOffsetFrom;
        this.timeZoneOffsetTo = timeZoneOffsetTo;
        this.timezoneName = timezoneName;
        this.dateTimeStart = dateTimeStart;
        this.rRule = rRule;
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
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getrRule() {
        return rRule;
    }

    public void setrRule(String rRule) {
        this.rRule = rRule;
    }
    //endregion

}
