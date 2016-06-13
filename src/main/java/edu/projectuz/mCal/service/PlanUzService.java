package edu.projectuz.mCal.service;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;

import java.util.List;

public interface PlanUzService {

    void saveCalendarsList(CalendarsList calendarsList);

    void saveTimetables(DepartmentsList departmentsList);

    DepartmentsList getAllTimetables();

    GroupTimetable getGroupTimetable(String name);
}
