package edu.projectuz.mCal.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.TimeZone;

import edu.projectuz.mCal.config.RootConfig;
import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.service.CalendarEventService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String args[]){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

        CalendarEventService service = (CalendarEventService) context.getBean("calendarEventService");

        String dateFormat = ("yyyy/MM/dd HH:mm");

        CalendarEvent calendarEvent1 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));

        CalendarEvent calendarEvent2 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));

		/*
		 * Persist both Employees
		 */
        service.saveCalendarEvent(calendarEvent1);
        service.saveCalendarEvent(calendarEvent2);

		/*
		 * Get all employees list from database
		 */
        List<CalendarEvent> calendarEvents = service.findAllCalendarEvent();
        for (CalendarEvent emp : calendarEvents) {
            System.out.println(emp);
        }

		/*
		 * delete an employee
		 */

		/*
		 * update an employee
		 */

        context.close();
    }

}
