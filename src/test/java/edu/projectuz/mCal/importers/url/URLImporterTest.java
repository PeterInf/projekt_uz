package edu.projectuz.mCal.importers.url;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.url.logic.URLImporter;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class URLImporterTest {
    @Test
    public void convertToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/url/filetest.html").getFile());
        URLImporter urlImporter = new URLImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Act
        CalendarEvent calendarEvent = new CalendarEvent("example1", new DateTime(Date.parse("2016/01/22 00:00")),
                new DateTime(Date.parse("2016/01/23 00:00")), "OPIS1", "Tag", TimeZone.getTimeZone("Europe/Warsaw"));

        //Assert
        assertEquals(calendarEvent, urlImporter.convertHTMLTableToObject().get(0));
        assertEquals(calendarEvent, urlImporter.convertHTMLTableToObject().get(1));
    }
}