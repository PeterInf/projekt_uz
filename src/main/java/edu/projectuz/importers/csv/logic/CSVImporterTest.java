package edu.projectuz.importers.csv.logic;

import edu.projectuz.core.models.CalendarEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;


public class CSVImporterTest {

    private CSVImporter csvImporter;

    @Before
    public void setUp() throws Exception {
        String filePath = "D:/Programy/IntelliJ IDEA/Projekty/webapp/src/main/java/edu/projectuz/importers/csv/resourcestmp/filetest.csv";
        this.csvImporter = new CSVImporter(filePath);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testConvertCsvToObjectTrue() throws Exception {
        assertEquals(new CalendarEvent("TPI KOŁO", new Date(Date.parse("2016/01/22 00:00")), new Date(Date.parse("2016/01/23 00:00")), "OPIS", "f", TimeZone.getTimeZone("America/Los_Angeles")),
                csvImporter.convertCsvToObject().get(0));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testConvertCsvToObjectFalse() throws Exception {
        assertEquals(new CalendarEvent("TPIFALSE", new Date(Date.parse("2016/01/22 00:00")), new Date(Date.parse("2016/01/23 00:00")), "O", "f", TimeZone.getTimeZone("America")),
                csvImporter.convertCsvToObject().get(0));
    }
}