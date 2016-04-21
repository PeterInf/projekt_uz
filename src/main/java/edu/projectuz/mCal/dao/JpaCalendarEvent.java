package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Piotr Różański on 4/21/2016.
 */
@Repository
@Transactional
public class JpaCalendarEvent implements CalendarEventRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public void create(CalendarEvent ce) {
        em.persist(ce);
    }

    @Override
    public CalendarEvent read(long id) {
        return em.find(CalendarEvent.class, id);
    }

    @Override
    public CalendarEvent update(CalendarEvent emp) {
        return em.merge(emp);
    }

    @Override
    public void delete(long id) {
        CalendarEvent ce=em.find(CalendarEvent.class, id);
        em.remove(ce);
    }
}
