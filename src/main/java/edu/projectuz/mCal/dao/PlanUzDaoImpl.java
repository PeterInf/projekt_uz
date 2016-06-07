package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("planUzDao")
public class PlanUzDaoImpl extends AbstractDao implements PlanUzDao  {

    public void saveCalendarsList(CalendarsList calendarsList) {
        persist(calendarsList);
    }

    public void saveTimetables(DepartmentsList departmentsList) {
        persist(departmentsList);
    }

    public DepartmentsList getAllTimetables() {
        Criteria criteria = getSession().createCriteria(DepartmentsList.class);
        return (DepartmentsList) criteria.uniqueResult();
    }
}
