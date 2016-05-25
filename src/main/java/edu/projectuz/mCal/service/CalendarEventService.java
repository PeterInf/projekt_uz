package edu.projectuz.mCal.service;

import edu.projectuz.mCal.core.models.CalendarEvent;

import java.util.List;

public interface CalendarEventService {

    void saveCalendarEvent(CalendarEvent calendarEvent);

    List<CalendarEvent> findAllCalendarEvent();

    void deleteCalendarEventById(int id);

    CalendarEvent findById(int id);

    void updateCalendarEvent(CalendarEvent calendarEvent);

    void deleteAll();
}
