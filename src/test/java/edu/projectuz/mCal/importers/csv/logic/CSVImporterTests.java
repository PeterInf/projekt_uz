package edu.projectuz.mCal.importers.csv.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * It's a test class for class {@link CSVImporter}.
 */
public class CSVImporterTests {

    /**
     * This test method compare the data received after used main method from {@link CSVImporter},
     * the data from the file.
     * The result should be positive.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void convertCsvToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/csv/filetest.csv").getFile());
        CSVImporter csvImporter = new CSVImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Act
        CalendarEvent calendarEvent = new CalendarEvent("TPI KOŁO", new DateTime(Date.parse("2016/01/22 00:00")),
                new DateTime(Date.parse("2016/01/23 00:00")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles"));

        //Assert
        System.err.println();
        assertEquals(calendarEvent, csvImporter.convertCsvToObject().get(0));
        assertEquals(calendarEvent, csvImporter.convertCsvToObject().get(1));
    }

    /**
     * This test checks the data for a single event.
     * Expected IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void badConvertCsv() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/csv/filebad1.csv").getFile());
        CSVImporter csvImporter = new CSVImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        csvImporter.convertCsvToObject().get(0);
    }

    /**
     * This test checks the data for a single event.
     * Expected IOException.
     */
    @Test(expected = IOException.class)
    public void bad2ConvertCsvToObject() throws Exception {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/csv/filebad2.csv").getFile());
        CSVImporter csvImporter = new CSVImporter(file.getAbsolutePath(), ImporterSourceType.FILE);

        //Assert
        csvImporter.convertCsvToObject().get(0);
    }
}