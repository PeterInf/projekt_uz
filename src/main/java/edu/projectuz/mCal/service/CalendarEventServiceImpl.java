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
public class CalendarEventServiceImpl implements CalendarEventService{

    @Autowired
    private CalendarEventDao dao;

    public void saveCalendarEvent(CalendarEvent calendarEvent) {
        dao.saveCalendarEvent(calendarEvent);
    }

    public List<CalendarEvent> findAllCalendarEvent() {
        return dao.findAllCalendarEvent();
    }

    public void deleteCalendarEventById(int id) {
        dao.deleteCalendarEventById(id);
    }

    public CalendarEvent findById(int id) {
        return dao.findById(id);
    }

    public void updateCalendarEvent(CalendarEvent calendarEvent){
        dao.updateCalendarEvent(calendarEvent);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public void saveCalendarEventsList(ArrayList<CalendarEvent> events) {
        dao.saveCalendarEventsList(events);
    }
}