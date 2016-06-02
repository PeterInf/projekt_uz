package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;

public interface PlanUzDao {

    void saveCalendarsList(CalendarsList calendars);
}
