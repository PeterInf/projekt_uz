package edu.projectuz.web.servlets;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarServletTests {

    private CalendarServlet calendarServlet;
    @Before
    public void setUp() throws Exception {
        calendarServlet = new CalendarServlet();
    }

    @Test
    public void testCount() throws Exception {
        int result = calendarServlet.testCount(2,2);

        assertEquals(4, result);
    }
}