package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;

public interface CalendarEventRepository {
    void create(CalendarEvent calendarEvent);
    CalendarEvent read(long id);
    CalendarEvent update(CalendarEvent calendarEvent);
    void delete(long id);
    void deleteAll();
}
