package edu.projectuz.mCal.dao;

import java.util.List;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("calendarEventDao")
public class CalendarEventDaoImpl extends AbstractDao implements CalendarEventDao{

    public void saveCalendarEvent(CalendarEvent calendarEvent) {
        persist(calendarEvent);
    }

    @SuppressWarnings("unchecked")
    public List<CalendarEvent> findAllCalendarEvent() {
        Criteria criteria = getSession().createCriteria(CalendarEvent.class);
        return (List<CalendarEvent>) criteria.list();
    }

    public void deleteCalendarEventById(int id) {
        Query query = getSession().createSQLQuery("delete from CalendarEvent where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }


    public CalendarEvent findById(int id){
        Criteria criteria = getSession().createCriteria(CalendarEvent.class);
        criteria.add(Restrictions.eq("id",id));
        return (CalendarEvent) criteria.uniqueResult();
    }

    public void updateCalendarEvent(CalendarEvent calendarEvent){
        getSession().update(calendarEvent);
    }

    public void deleteAll() {
        Query query = getSession().createSQLQuery("delete from CalendarEvent");
        query.executeUpdate();
    }
}
