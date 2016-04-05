package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

/**
 * Created by Sivik on 05-Apr-16.
 */
public class ICalModel {

    private String version;
    private String prodId;
    private String calscale;

    private ArrayList<ICalTimeZone> TimeZones = new ArrayList<ICalTimeZone>();

    private ArrayList<ICalEvent> Events = new ArrayList<ICalEvent>();

    public ICalModel(String version, String prodId, String calscale, ArrayList<ICalTimeZone> timeZones, ArrayList<ICalEvent> events) {
        this.version = version;
        this.prodId = prodId;
        this.calscale = calscale;
        TimeZones = timeZones;
        Events = events;
    }
    //region ICalModels Getter and Setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getCalscale() {
        return calscale;
    }

    public void setCalscale(String calscale) {
        this.calscale = calscale;
    }

    public ArrayList<ICalTimeZone> getTimeZones() {
        return TimeZones;
    }

    public void setTimeZones(ArrayList<ICalTimeZone> timeZones) {
        TimeZones = timeZones;
    }

    public ArrayList<ICalEvent> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<ICalEvent> events) {
        Events = events;
    }
    //endregion
}
