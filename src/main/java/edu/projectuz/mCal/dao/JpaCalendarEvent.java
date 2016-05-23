package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaCalendarEvent implements CalendarEventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public final void create(final CalendarEvent calendarEvent) {
        entityManager.persist(calendarEvent);
    }

    @Override
    public final CalendarEvent read(final long id) {
        return entityManager.find(CalendarEvent.class, id);
    }

    @Override
    public final CalendarEvent update(final CalendarEvent calendarEvent) {
        return entityManager.merge(calendarEvent);
    }

    @Override
    public final void delete(final long id) {
        CalendarEvent calendarEvent =
                entityManager.find(CalendarEvent.class, id);
        entityManager.remove(calendarEvent);
    }

    @Override
    public void deleteAll() {
        //TODO:
    }
}
