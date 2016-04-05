package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

/**
 * Created by Sivik on 05-Apr-16.
 */
public class ICalTimeZone {
    private String timeZoneId;  //timeZone id  etc. continent/country
    private String timeZoneUrl;
    private String location;
    private ArrayList <ICalTimeZoneProperty> propertyTimeZones = new ArrayList<>();

    public ICalTimeZone(String timeZoneId, String timeZoneUrl, String location, ArrayList<ICalTimeZoneProperty> propertyTimeZones) {
        this.timeZoneId = timeZoneId;
        this.timeZoneUrl = timeZoneUrl;
        this.location = location;
        this.propertyTimeZones = propertyTimeZones;
    }

    //region ICalTimeZone Getters and Setters
    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getTimeZoneUrl() {
        return timeZoneUrl;
    }

    public void setTimeZoneUrl(String timeZoneUrl) {
        this.timeZoneUrl = timeZoneUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<ICalTimeZoneProperty> getPropertyTimeZones() {
        return propertyTimeZones;
    }

    public void setPropertyTimeZones(ArrayList<ICalTimeZoneProperty> propertyTimeZones) {
        this.propertyTimeZones = propertyTimeZones;
    }
    //endregion
}
