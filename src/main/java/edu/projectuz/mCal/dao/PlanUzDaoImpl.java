package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.GroupTimetable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sun.security.acl.GroupImpl;

import java.util.ArrayList;
import java.util.List;

@Repository("planUzDao")
public class PlanUzDaoImpl extends AbstractDao implements PlanUzDao  {

    public final void saveCalendarsList(
            final CalendarsList calendarsList) {
        persist(calendarsList);
    }

    public void saveTimetables(DepartmentsList departmentsList) {
        persist(departmentsList);
    }

    public DepartmentsList getAllTimetables() {
        Criteria criteria = getSession().createCriteria(DepartmentsList.class);
        return (DepartmentsList) criteria.uniqueResult();
    }

    public GroupTimetable getGroupTimetable(String name) {
        Criteria criteria = getSession().createCriteria(GroupTimetable.class);
        criteria.add(Restrictions.eq("name", name));
        return (GroupTimetable) criteria.uniqueResult();
    }

    public List<Calendar> getCalendarsList() {
        Criteria criteria = getSession().createCriteria(Calendar.class);

        return (List<Calendar>) criteria.list();
    }
}
