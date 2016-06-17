package edu.projectuz.mCal.service;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.CalendarEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("calendarEventService")
@Transactional
public class CalendarEventServiceImpl implements CalendarEventService {

    @Autowired
    private CalendarEventDao dao;

    public final void saveCalendarEvent(
            final CalendarEvent calendarEvent) {
        dao.saveCalendarEvent(calendarEvent);
    }

    public final List<CalendarEvent> findAllCalendarEvent() {
        return dao.findAllCalendarEvent();
    }

    public final void deleteCalendarEventById(
            final int id) {
        dao.deleteCalendarEventById(id);
    }

    public final CalendarEvent findById(final int id) {
        return dao.findById(id);
    }

    public final void updateCalendarEvent(
            final CalendarEvent calendarEvent) {
        dao.updateCalendarEvent(calendarEvent);
    }

    public final void deleteAll() {
        dao.deleteAll();
    }

    public final void saveCalendarEventsList(
            final ArrayList<CalendarEvent> events) {
        dao.saveCalendarEventsList(events);
    }
}
