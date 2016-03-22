package edu.projectuz.importers.planuz.model.calendars;

public class Day {

    private int number;
    private String date;
    private String dayAccordingToTimetable;
    private String getDayAccordingToCalendar;

    public Day(int number, String date, String dayAccordingToTimetable, String getDayAccordingToCalendar) {
        this.number = number;
        this.date = date;
        this.dayAccordingToTimetable = dayAccordingToTimetable;
        this.getDayAccordingToCalendar = getDayAccordingToCalendar;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "number=" + number +
                ", date=" + date +
                ", dayAccordingToTimetable='" + dayAccordingToTimetable + '\'' +
                ", getDayAccordingToCalendar='" + getDayAccordingToCalendar + '\'' +
                '}';
    }

}
