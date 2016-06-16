package edu.projectuz.mCal.importers.ical.model;

import java.util.ArrayList;

public class ICalModel {

    private String version;
    private String prodId;
    private String calscale;

    private ArrayList<ICalTimeZone> timeZones = new ArrayList<>();

    private ArrayList<ICalEvent> events = new ArrayList<>();

    public ICalModel(final String aVersion,
                     final String aProdId,
                     final String aCalscale,
                     final ArrayList<ICalTimeZone> aTimeZones,
                     final ArrayList<ICalEvent> anEvents) {
        this.version = aVersion;
        this.prodId = aProdId;
        this.calscale = aCalscale;
        this.timeZones = aTimeZones;
        this.events = anEvents;
    }

    public ICalModel() {
    }

    //region ICalModels Getter and Setters
    public final String getVersion() {
        return version;
    }

    public final void setVersion(final String aVersion) {
        this.version = aVersion;
    }

    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(final String aProdId) {
        this.prodId = aProdId;
    }

    public final String getCalscale() {
        return calscale;
    }

    public final void setCalscale(final String aCalscale) {
        this.calscale = aCalscale;
    }

    public final ArrayList<ICalTimeZone> getTimeZones() {
        return timeZones;
    }

    public final void setTimeZones(final ArrayList<ICalTimeZone> aTimeZones) {
        this.timeZones = aTimeZones;
    }

    public final ArrayList<ICalEvent> getEvents() {
        return events;
    }

    public final void setEvents(final ArrayList<ICalEvent> anEvents) {
        this.events = anEvents;
    }
    //endregion
}
