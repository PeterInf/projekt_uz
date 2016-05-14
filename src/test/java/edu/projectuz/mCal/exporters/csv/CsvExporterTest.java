package edu.projectuz.mCal.exporters.csv;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TimeZone;

public class CsvExporterTest {
    @Test
    public void generateCsvFile() throws Exception {
        //Arrange
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();
        CsvExporter csvExporter = new CsvExporter("d:/test.csv");
        String dateFormat = ("yyyy/MM/dd HH:mm");

        //Act
        CalendarEvent event1 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));
        CalendarEvent event2 = new CalendarEvent("TPI KOŁO", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 00:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), "OPIS", "f", TimeZone.getTimeZone("Europe/Warsaw"));

        listOfEvents.add(event1);
        listOfEvents.add(event2);

        csvExporter.generateCsvFile(listOfEvents);

        //Assert

    }
}