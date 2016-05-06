package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArrayListEventsRepository implements CalendarEventRepository {

    private List<CalendarEvent> calendarEventList = new ArrayList<>();
    @Override
    public void create(CalendarEvent calendarEvent) {
        calendarEventList.add(calendarEvent);
    }

    @Override
    public CalendarEvent read(long id) {
        return null;
    }

    @Override
    public CalendarEvent update(CalendarEvent calendarEvent) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    public List<CalendarEvent> getAll() {
        return calendarEventList;
    }
}
