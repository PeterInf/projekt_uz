package edu.projectuz.importers.csv.logic;

import edu.projectuz.core.models.CalendarEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;

/**
 * It's a test class for class {@link CSVImporter}.
 */
public class CSVImporterTest {

    private CSVImporter csvImporter;

    /**
     * This method sets the member variables.
     *
     * @throws Exception on input error.
     */
    @Before
    public void setUp() throws Exception {
        String filePath = "D:/Programy/IntelliJ IDEA/Projekty/webapp/src/main/java/edu/projectuz/importers/csv/resourcestmp/filetest.csv";
        this.csvImporter = new CSVImporter(filePath);
    }

    /**
     * This test method compare the data received after used main method from {@link CSVImporter},
     * the data from the file.
     * The result should be positive.
     *
     * @throws Exception on input error.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testConvertCsvToObjectTrue() throws Exception {
        assertEquals(new CalendarEvent("TPI KOŁO", new Date(Date.parse("2016/01/22 00:00")), new Date(Date.parse("2016/01/23 00:00")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles")),
                csvImporter.convertCsvToObject().get(0));
    }

    /**
     * This test method compare the data received after used main method from {@link CSVImporter},
     * the data from the file.
     * The result should be negative.
     *
     * @throws Exception on input error.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testConvertCsvToObjectFalse() throws Exception {
        assertEquals(new CalendarEvent("TPIFALSE", new Date(Date.parse("2016/01/22 00:00")), new Date(Date.parse("2016/01/23 00:00")), "O", "f", TimeZone.getTimeZone("America")),
                csvImporter.convertCsvToObject().get(0));
    }
}