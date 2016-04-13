package edu.projectuz.mCal.importers.planuz.model.timetables;

import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import edu.projectuz.mCal.importers.planuz.model.calendars.DaysList;

/**
 * This class represents a single entry in planUz timetable.
 * For example it could be a class, exam or anything else that can
 * be write to timetable.
 * Structure of this object is similar to this from planUz website.
 */
public class TimetableEvent {

    private String subgroup;
    private String startTime;
    private String endTime;
    private String eventName;
    private String eventType;
    private String teacherName;
    private String room;

    /**
     * This variable can either contain few days like "19-03-2016; 02-04-2016; 16-04-2016;"
     * or just a type of days from a planUz {@link Calendar}
     * which is stored in ({@link DaysList}) object.
     */
    private String days;

    /**
     * Class constructor that sets all the information about a event.
     * @param subgroup - name of subgroup for this event.
     * @param startTime - start time of event
     * @param endTime - end time of event
     * @param eventName - name of event
     * @param eventType - type of event, for example: W - wykład, L - laboratoria...
     * @param teacherName - name of a teacher
     * @param room - room name or number
     * @param days - type of days from particular calendar or just some dates
     */
    public TimetableEvent(String subgroup, String startTime, String endTime, String eventName,
                          String eventType, String teacherName, String room, String days) {
        this.subgroup = subgroup;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.teacherName = teacherName;
        this.room = room;
        this.days = days;
    }

    /**
     * @return Subgroup name.
     */
    public String getSubgroup() {
        return subgroup;
    }

    /**
     * @return Start time for example "9:15".
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @return End time for example "10:45".
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @return Event name.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @return Event type.
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @return Teacher name.
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @return Room name.
     */
    public String getRoom() {
        return room;
    }

    /**
     * @return Type of days from calendar or dates.
     */
    public String getDays() {
        return days;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     * @return Returns converted String.
     */
    @Override
    public String toString() {
        return "TimetableEvent{" +
                "subgroup='" + subgroup + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", room='" + room + '\'' +
                ", days='" + days + '\'' +
                '}';
    }
}
