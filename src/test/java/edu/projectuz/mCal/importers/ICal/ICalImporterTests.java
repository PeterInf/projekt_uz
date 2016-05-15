package edu.projectuz.mCal.importers.ICal;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.ical.logic.ICalImporter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.File;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * It's a test class for class {@link ICalImporterTests}.
 */
public class ICalImporterTests {

    /**
     * This test method compare the data received after used main method from {@link ICallImporter},
     * the data from the file.
     * The result should be positive.
     */
    @Test
    public void convertICalToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/ical/sample.ics").getFile());
        ICalImporter iCalImporter = new ICalImporter(file.getAbsolutePath(), ImporterSourceType.FILE);
        String dateFormat = ("yyyy/MM/dd HH:mm");

        //Act
        CalendarEvent calendarEvent = new CalendarEvent("Access-A-Ride Pickup",
                new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2013/08/02 10:34")),
                new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2013/08/02 11:04")),
                "Access-A-Ride to 900 Jay St., Brooklyn", "", TimeZone.getTimeZone("America/New_York"));
        //Assert
        assertEquals(calendarEvent, iCalImporter.convertICalToObject().get(0));
    }

    /**
     * This test checks the data for a single event.
     * Expected Exception.
     */
    @Test(expected = Exception.class)
    public void badConvertICal() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/ical/BadIcal.ics").getFile());
        ICalImporter iCalImporter = new ICalImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        iCalImporter.convertICalToObject().get(0);
    }

    /**
     * This test checks the data for a single event.
     * Expected Exception.
     */
    @Test(expected = Exception.class)
    public void bad2ConvertICalToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/ical/NoFullIcal.ics").getFile());
        ICalImporter iCalImporter = new ICalImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        iCalImporter.convertICalToObject().get(0);
    }
}