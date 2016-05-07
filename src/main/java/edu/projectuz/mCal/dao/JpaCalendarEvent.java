package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaCalendarEvent implements CalendarEventRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(CalendarEvent calendarEvent) {
        entityManager.persist(calendarEvent);
    }

    @Override
    public CalendarEvent read(long id) {
        return entityManager.find(CalendarEvent.class, id);
    }

    @Override
    public CalendarEvent update(CalendarEvent calendarEvent) {
        return entityManager.merge(calendarEvent);
    }

    @Override
    public void delete(long id) {
        CalendarEvent calendarEvent= entityManager.find(CalendarEvent.class, id);
        entityManager.remove(calendarEvent);
    }

    @Override
    public void deleteAll() {
        //TODO:
    }
}
