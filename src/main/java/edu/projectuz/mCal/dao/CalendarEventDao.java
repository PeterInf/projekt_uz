package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;

import java.util.List;

public interface CalendarEventDao {

    void saveCalendarEvent(CalendarEvent calendarEvent);

    List<CalendarEvent> findAllCalendarEvent();

    void deleteCalendarEventBySsn(String ssn);

    CalendarEvent findBySsn(String ssn);

    void updateCalendarEvent(CalendarEvent employee);
}
