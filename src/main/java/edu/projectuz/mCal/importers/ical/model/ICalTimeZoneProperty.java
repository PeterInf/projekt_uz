package edu.projectuz.mCal.importers.ical.model;

public class ICalTimeZoneProperty {
    private String nameTimeZone;
    private String timeZoneOffsetFrom;
    private String timeZoneOffsetTo;
    private String timezoneName;
    private String dateTimeStart;
    private String rRule;

    public ICalTimeZoneProperty(final String aNameTimeZone,
                                final String aTimeZoneOffsetFrom,
                                final String aTimeZoneOffsetTo,
                                final String aTimezoneName,
                                final String aDateTimeStart,
                                final String aRRule) {
        this.nameTimeZone = aNameTimeZone;
        this.timeZoneOffsetFrom = aTimeZoneOffsetFrom;
        this.timeZoneOffsetTo = aTimeZoneOffsetTo;
        this.timezoneName = aTimezoneName;
        this.dateTimeStart = aDateTimeStart;
        this.rRule = aRRule;
    }

    //region ICalTimeZoneProperty Getters and Setters
    public final String getNameTimeZone() {
        return nameTimeZone;
    }

    public final void setNameTimeZone(final String aNameTimeZone) {
        this.nameTimeZone = aNameTimeZone;
    }

    public final String getTimeZoneOffsetFrom() {
        return timeZoneOffsetFrom;
    }

    public final void setTimeZoneOffsetFrom(final String aTimeZoneOffsetFrom) {
        this.timeZoneOffsetFrom = aTimeZoneOffsetFrom;
    }

    public final String getTimeZoneOffsetTo() {
        return timeZoneOffsetTo;
    }

    public final void setTimeZoneOffsetTo(final String aTimeZoneOffsetTo) {
        this.timeZoneOffsetTo = aTimeZoneOffsetTo;
    }

    public final String getTimezoneName() {
        return timezoneName;
    }

    public final void setTimezoneName(final String aTimezoneName) {
        this.timezoneName = aTimezoneName;
    }

    public final String getDateTimeStart() {
        return dateTimeStart;
    }

    public final void setDateTimeStart(final String aDateTimeStart) {
        this.dateTimeStart = aDateTimeStart;
    }

    public final String getrRule() {
        return rRule;
    }

    public final void setrRule(final String aRRule) {
        this.rRule = aRRule;
    }
    //endregion

}
