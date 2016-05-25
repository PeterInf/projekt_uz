package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void deleteAll() {
        calendarEventList = new ArrayList<>();
    }

    public CalendarEvent read(String title) {
        for(CalendarEvent calendarEvent : calendarEventList) {
            if(calendarEvent.getTitle().equals(title)) {
                return calendarEvent;
            }
        }
        throw new IllegalArgumentException(String.format("No calendar with title '%s' found", title));
    }

    public void delete(String title) {
        Iterator<CalendarEvent> iterator = calendarEventList.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getTitle().equals(title)) {
                iterator.remove();
            }
        }
    }
}
