package edu.projectuz.mCal.importers.csv.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;

/**
 * It's a test class for class {@link CSVImporter}.
 */
public class CSVImporterTests {

    private CSVImporter csvImporter;

    /**
     * This method sets the member variables.
     *
     * @throws Exception on input error.
     */
    @Before
    public void setUp() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getClass().getResource("/csv/filetest.csv").getFile());
        this.csvImporter = new CSVImporter(file.getAbsolutePath());
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
    public void ConvertCsvToObject() throws Exception {
        assertEquals(new CalendarEvent("TPI KOŁO", new Date(Date.parse("2016/01/22 00:00")), new Date(Date.parse("2016/01/23 00:00")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles")),
                csvImporter.convertCsvToObject().get(0));
    }
}