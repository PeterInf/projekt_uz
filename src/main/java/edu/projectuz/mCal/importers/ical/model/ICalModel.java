package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalModel {

    private String version;
    private String prodId;
    private String calscale;

    private ArrayList<ICalTimeZone> timeZones = new ArrayList<>();

    private ArrayList<ICalEvent> events = new ArrayList<>();

    public ICalModel(String version, String prodId, String calscale, ArrayList<ICalTimeZone> timeZones, ArrayList<ICalEvent> events) {
        this.version = version;
        this.prodId = prodId;
        this.calscale = calscale;
        this.timeZones = timeZones;
        this.events = events;
    }
    public ICalModel(){}

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
        return timeZones;
    }

    public void setTimeZones(ArrayList<ICalTimeZone> timeZones) {
        this.timeZones = timeZones;
    }

    public ArrayList<ICalEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<ICalEvent> events) {
        this.events = events;
    }
    //endregion
}
