package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalTimeZone {
    private String timeZoneId;  //timeZone id  etc. continent/country
    private String timeZoneUrl;
    private String location;
    private ArrayList<ICalTimeZoneProperty>
            propertyTimeZones = new ArrayList<>();

    public ICalTimeZone(
            final String aTimeZoneId,
            final String aTimeZoneUrl,
            final String aLocation,
            final ArrayList<ICalTimeZoneProperty> aPropertyTimeZones) {
        this.timeZoneId = aTimeZoneId;
        this.timeZoneUrl = aTimeZoneUrl;
        this.location = aLocation;
        this.propertyTimeZones = aPropertyTimeZones;
    }

    //region ICalTimeZone Getters and Setters
    public final String getTimeZoneId() {
        return timeZoneId;
    }

    public final void setTimeZoneId(final String aTimeZoneId) {
        this.timeZoneId = aTimeZoneId;
    }

    public final String getTimeZoneUrl() {
        return timeZoneUrl;
    }

    public final void setTimeZoneUrl(final String aTimeZoneUrl) {
        this.timeZoneUrl = aTimeZoneUrl;
    }

    public final String getLocation() {
        return location;
    }

    public final void setLocation(final String aLocation) {
        this.location = aLocation;
    }

    public final ArrayList<ICalTimeZoneProperty> getPropertyTimeZones() {
        return propertyTimeZones;
    }

    public final void setPropertyTimeZones(
            final ArrayList<ICalTimeZoneProperty> aPropertyTimeZones) {
        this.propertyTimeZones = aPropertyTimeZones;
    }
    //endregion
}
