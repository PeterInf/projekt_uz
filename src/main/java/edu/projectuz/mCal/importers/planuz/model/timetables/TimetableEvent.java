package edu.projectuz.mCal.importers.planuz.model.timetables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 * This class represents a single entry in planUz timetable.
 * For example it could be a class, exam or anything else that can
 * be write to timetable.
 * Structure of this object is similar to this from planUz website.
 */
@Entity
public class TimetableEvent {
    @Id
    @GeneratedValue
    private int id;

    private String subgroup;
    private String startTime;
    private String endTime;
    private String eventName;
    private String eventType;

    @Size(max = 500)
    private String teacherName;
    private String room;

    /**
     * This variable can either contain few
     * days like "19-03-2016; 02-04-2016; 16-04-2016;"
     * or just a type of days from a planUz {@link Calendar}
     * which is stored in ({@link DaysList}) object.
     */
    private String days;
    private String dayName;

    /**
     * Class constructor that sets all the information about a event.
     *
     * @param aSubgroup    - name of subgroup for this event.
     * @param aStartTime   - start time of event
     * @param anEndTime    - end time of event
     * @param anEventName  - name of event
     * @param anEventType  - type of event, for example:
     *                     W - wykład, L - laboratoria...
     * @param aTeacherName - name of a teacher
     * @param aRoom        - room name or number
     * @param aDays        - type of days from
     *                     particular calendar or just some dates
     */
    public TimetableEvent(final String aSubgroup, final String aStartTime,
                          final String anEndTime, final String anEventName,
                          final String anEventType, final String aTeacherName,
                          final String aRoom, final String aDays) {
        this.subgroup = aSubgroup;
        this.startTime = aStartTime;
        this.endTime = anEndTime;
        this.eventName = anEventName;
        this.eventType = anEventType;
        this.teacherName = aTeacherName;
        this.room = aRoom;
        this.days = aDays;
    }

    /**
     * @return Subgroup name.
     */
    public final String getSubgroup() {
        return subgroup;
    }

    /**
     * @return Start time for example "9:15".
     */
    public final String getStartTime() {
        return startTime;
    }

    /**
     * @return End time for example "10:45".
     */
    public final String getEndTime() {
        return endTime;
    }

    /**
     * @return Event name.
     */
    public final String getEventName() {
        return eventName;
    }

    /**
     * @return Event type.
     */
    public final String getEventType() {
        return eventType;
    }

    /**
     * @return Teacher name.
     */
    public final String getTeacherName() {
        return teacherName;
    }

    /**
     * @return Room name.
     */
    public final String getRoom() {
        return room;
    }

    /**
     * @return Type of days from calendar or dates.
     */
    public final String getDays() {
        return days;
    }

    /**
     * Sets day name
     *
     * @param aDayName - day of the week
     */
    public final void setDayName(final String aDayName) {
        this.dayName = aDayName;
    }

    /**
     * Gets day name
     *
     * @return TimetableDay of the week
     */
    public final String getDayName() {
        return dayName;
    }

    /**
     * Converts object of this class to String object with all of it's content.
     *
     * @return Returns converted String.
     */
    @Override
    public final String toString() {
        return "TimetableEvent{" + "subgroup='" + subgroup + '\''
                + ", startTime='" + startTime + '\'' + ", endTime='"
                + endTime + '\'' + ", eventName='" + eventName + '\''
                + ", eventType='" + eventType + '\''
                + ", teacherName='" + teacherName + '\'' + ", room='"
                + room + '\'' + ", days='" + days + '\'' + ", dayName='"
                + dayName + '\'' + '}';
    }

    //region getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDays(String days) {
        this.days = days;
    }
    //endregion
}
