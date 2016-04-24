package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;

public interface CalendarEventRepository {
    public void create(CalendarEvent calendarEvent);
    public CalendarEvent read(long id);
    public CalendarEvent update(CalendarEvent calendarEvent);
    public void delete(long id);
}
