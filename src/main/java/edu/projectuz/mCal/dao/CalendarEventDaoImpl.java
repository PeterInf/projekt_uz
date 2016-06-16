package edu.projectuz.mCal.dao;

import java.util.ArrayList;
import java.util.List;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("calendarEventDao")
public class CalendarEventDaoImpl extends AbstractDao
        implements CalendarEventDao {

    public final void saveCalendarEvent(
            final CalendarEvent calendarEvent) {
        persist(calendarEvent);
    }

    @SuppressWarnings("unchecked")
    public final List<CalendarEvent> findAllCalendarEvent() {
        Criteria criteria = getSession().createCriteria(CalendarEvent.class);
        return (List<CalendarEvent>) criteria.list();
    }

    public final void deleteCalendarEventById(final int id) {
        Query query = getSession().createSQLQuery(
                "delete from CalendarEvent where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }


    public final CalendarEvent findById(final int id) {
        Criteria criteria = getSession().createCriteria(CalendarEvent.class);
        criteria.add(Restrictions.eq("id", id));
        return (CalendarEvent) criteria.uniqueResult();
    }

    public final void updateCalendarEvent(
            final CalendarEvent calendarEvent) {
        getSession().update(calendarEvent);
    }

    public final void deleteAll() {
        Query query = getSession().createSQLQuery("delete from CalendarEvent");
        query.executeUpdate();
    }

    public final void saveCalendarEventsList(
            final ArrayList<CalendarEvent> events) {
        events.forEach(this::persist);
    }
}
