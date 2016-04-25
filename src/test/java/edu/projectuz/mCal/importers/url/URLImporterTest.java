package edu.projectuz.mCal.importers.url;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.url.logic.URLImporter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.File;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class URLImporterTest {
    @Test
    public void convertToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/url/filetest.html").getFile());
        URLImporter urlImporter = new URLImporter(file.getAbsolutePath(), ImporterSourceType.FILE);
        String dateFormat = ("yyyy/MM/dd HH:mm");

        //Act
        CalendarEvent calendarEvent = new CalendarEvent("example1", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 01:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 15:00"))
                .withZone(DateTimeZone.forID("Europe/Warsaw")), "OPIS1", "Tag", TimeZone.getTimeZone("Europe/Warsaw"));
        CalendarEvent calendarEvent1 = new CalendarEvent("example1", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 01:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("America/Los_Angeles")), "OPIS1", "Tag", TimeZone.getTimeZone("America/Los_Angeles"));

        //Assert
        assertEquals(calendarEvent, urlImporter.convertToObject().get(0));
        assertEquals(calendarEvent1, urlImporter.convertToObject().get(1));
    }
}