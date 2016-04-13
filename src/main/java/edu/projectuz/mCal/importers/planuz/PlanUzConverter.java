package edu.projectuz.mCal.importers.planuz;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.planuz.logic.calendars.CalendarsListImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.Day;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import edu.projectuz.mCal.importers.planuz.model.timetables.TimetableEvent;

import java.util.ArrayList;

/**
 * This class can be used for converting planUz group
 * timetable object ({@link GroupTimetable}) into
 * list of {@link CalendarEvent} objects.
 */
public class PlanUzConverter {

    private CalendarsList calendarsList;

    /**
     * Class constructor that imports calendars which
     * will be used in converting process.
     */
    public PlanUzConverter() {
        calendarsList = getCalendars();
    }

    /**
     * Main function of this class. Allows you to convert
     * a single planUz timetable into list of events.
     * @param timetable - planUz timetable
     * @return List of events.
     */
    public ArrayList<CalendarEvent> convertTimetable(GroupTimetable timetable) {
        ArrayList<CalendarEvent> calendarEvents = new ArrayList<>();
        addEventsToList(timetable, calendarEvents);
        return calendarEvents;
    }

    private void addEventsToList(GroupTimetable timetable, ArrayList<CalendarEvent> calendarEvents) {
        for(Day day : timetable.getDaysList()) {
            for(TimetableEvent timetableEvent : day.getEventsList()) {
                calendarEvents.add(convertToCalendarEvent(timetableEvent));
            }
        }
    }

    private CalendarEvent convertToCalendarEvent(TimetableEvent timetableEvent) {
        return null;
    }

    /**
     * This function will be changed to get calendars from
     * database instead of importer itself.
     */
    private CalendarsList getCalendars() {
        String calendarsUrl = "http://plan.uz.zgora.pl/kalendarze_lista.php";
        return new CalendarsListImporter(calendarsUrl).importCalendars();
    }
}
