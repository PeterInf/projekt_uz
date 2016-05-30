package edu.projectuz.mCal.importers.xml;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.File;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * It's a test class for class {@link XMLImporter}.
 */
public class XMLImporterTests {

    /**
     * This test method compare the data received after used main method from {@link XMLImporter},
     * the data from the file.
     * The result should be positive.
     */
    @Test
    public void convertToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/xml/filetest.xml").getFile());
        XMLImporter xmlImporter = new XMLImporter(file.getAbsolutePath(), ImporterSourceType.FILE);
        String dateFormat = ("yyyy/MM/dd HH:mm");

        //Act
        CalendarEvent calendarEvent = new CalendarEvent("Planning meeting", new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/22 15:00"))
                .withZone(DateTimeZone.forID("Europe/Berlin")), new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime("2016/01/23 00:00"))
                .withZone(DateTimeZone.forID("Europe/Berlin")), "We are having a meeting", "f", TimeZone.getTimeZone("Europe/Berlin"));

        //Assert
        assertEquals(calendarEvent, xmlImporter.convertToObject().get(0));
    }

    /**
     * This test checks the data for a single event.
     * Expected IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void badDate() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/xml/badDateXml.xml").getFile());
        XMLImporter xmlImporter = new XMLImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        xmlImporter.convertToObject().get(0);
    }

    /**
     * This test checks the data for a single event.
     * Expected IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void lackOfEvent() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/xml/lackOfEventXml.xml").getFile());
        XMLImporter xmlImporter = new XMLImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        xmlImporter.convertToObject().get(0);
    }
}