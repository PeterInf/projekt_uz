package edu.projectuz.importers.planuz.model.timetables;

import edu.projectuz.importers.planuz.model.calendars.Calendar;
import edu.projectuz.importers.planuz.model.calendars.DaysList;

public class TimetableEvent {

    private String subgroup;
    private String startTime;
    private String endTime;
    private String className;
    private String classType;
    private String teacherName;
    private String room;

    /**
     * This variable can either contain few days like "19-03-2016; 02-04-2016; 16-04-2016;"
     * or just a type of days from a planUz {@link Calendar}
     * which is stored in ({@link DaysList}) object.
     */
    private String days;

    public TimetableEvent(String subgroup, String startTime, String endTime, String className,
                          String classType, String teacherName, String room, String days) {
        this.subgroup = subgroup;
        this.startTime = startTime;
        this.endTime = endTime;
        this.className = className;
        this.classType = classType;
        this.teacherName = teacherName;
        this.room = room;
        this.days = days;
    }

    @Override
    public String toString() {
        return "TimetableEvent{" +
                "subgroup='" + subgroup + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", className='" + className + '\'' +
                ", classType='" + classType + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", room='" + room + '\'' +
                ", days='" + days + '\'' +
                '}';
    }
}
