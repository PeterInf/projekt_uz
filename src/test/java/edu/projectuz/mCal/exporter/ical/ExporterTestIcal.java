package edu.projectuz.mCal.exporter.ical;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.exporters.ical.ICalExporter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TimeZone;

public class ExporterTestIcal {
    ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();
    ICalExporter iCalExporter = new ICalExporter();

    @Before
    public void addDataForTest() {
        String dateFormat = ("yyyy/MM/dd HH:mm");
        CalendarEvent event1 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));
        CalendarEvent event2 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 02:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), "OPIS", "f", TimeZone.getTimeZone("Europe/Warsaw"));
        listOfEvents.add(event1);
        listOfEvents.add(event2);
    }

    @Test
    public void generateIcalString() throws IOException {
        iCalExporter.generateICal(listOfEvents);
    }

}