package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import org.springframework.stereotype.Repository;

@Repository("planUzDao")
public class PlanUzDaoImpl extends AbstractDao implements PlanUzDao  {

    public final void saveCalendarsList(
            final CalendarsList calendarsList) {
        persist(calendarsList);
    }
}
