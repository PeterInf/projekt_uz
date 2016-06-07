package edu.projectuz.mCal.service;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;

public interface PlanUzService {

    void saveCalendarsList(CalendarsList calendarsList);

    void saveTimetables(DepartmentsList departmentsList);
}
