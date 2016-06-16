package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ArrayListEventsRepository {

    private List<CalendarEvent> calendarEventList = new ArrayList<>();

    public final void create(final CalendarEvent calendarEvent) {
        calendarEventList.add(calendarEvent);
    }

    public final CalendarEvent read(final long id) {
        return null;
    }

    public final CalendarEvent update(final CalendarEvent calendarEvent) {
        return null;
    }

    public void delete(final long id) {

    }

    public final List<CalendarEvent> getAll() {
        return calendarEventList;
    }

    public final void deleteAll() {
        calendarEventList = new ArrayList<>();
    }

    public final CalendarEvent read(final String title) {
        for (CalendarEvent calendarEvent : calendarEventList) {
            if (calendarEvent.getTitle().equals(title)) {
                return calendarEvent;
            }
        }
        throw new IllegalArgumentException(
                String.format("No calendar with title '%s' found", title));
    }

    public final void delete(final String title) {
        Iterator<CalendarEvent> iterator = calendarEventList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitle().equals(title)) {
                iterator.remove();
            }
        }
    }
}
