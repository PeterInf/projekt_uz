package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;

import java.util.List;

public interface CalendarEventDao {

    void saveCalendarEvent(CalendarEvent calendarEvent);

    List<CalendarEvent> findAllCalendarEvent();

    void deleteCalendarEventById(int id);

    CalendarEvent findById(int id);

    void updateCalendarEvent(CalendarEvent employee);

    void deleteAll();
}
