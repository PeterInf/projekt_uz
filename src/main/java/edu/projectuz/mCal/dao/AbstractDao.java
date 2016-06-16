package edu.projectuz.mCal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public final void persist(final Object entity) {
        getSession().persist(entity);
    }

    public final void delete(final Object entity) {
        getSession().delete(entity);
    }
}
