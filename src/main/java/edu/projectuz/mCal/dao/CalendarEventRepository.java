package edu.projectuz.mCal.dao;

import edu.projectuz.mCal.core.models.CalendarEvent;

/**
 * Created by Piotr Różański on 4/21/2016.
 */
public interface CalendarEventRepository {
    public void create(CalendarEvent ce);
    public CalendarEvent read(long id);
    public CalendarEvent update(CalendarEvent emp);
    public void delete(long id);
}
