package edu.projectuz.importers.csv.logic;

import edu.projectuz.core.models.CalendarEvent;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class is main class for importer CSV.
 *
 *
 *
 */
public class CSVImporter {

    private FileReader fileReader;

    public CSVImporter(String filePath) {
        try {
            this.fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * This is a main function of this class.
     * It is used to import data from .csv file.
     * @return Returned list of events.
     */
    public ArrayList<CalendarEvent> convertCsvToObject() throws IOException {
        String[] header = {"TITLE", "START", "END", "DESCRIPTION", "TAG", "TIMEZONE"};
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',').withHeader(header).withSkipHeaderRecord(true);
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<CalendarEvent>();

        CSVParser parser = new CSVParser(fileReader, format);
        for (CSVRecord csvRecord : parser) {
            CalendarEvent eventObject = new CalendarEvent();
            eventObject.setTitle(csvRecord.get("TITLE"));
            eventObject.setStartDate(convertStringToDate(csvRecord.get("START")));
            eventObject.setEndDate(convertStringToDate(csvRecord.get("END")));
            eventObject.setDescription(csvRecord.get("DESCRIPTION"));
            eventObject.setTag(csvRecord.get("TAG"));
            eventObject.setTimeZone(convertStringToTimeZone(csvRecord.get("TIMEZONE")));
            listOfEvents.add(eventObject);
        }
        fileReader.close();
        return listOfEvents;
    }

    /**
     * This function converts a date from String ("yyyy/MM/dd hh:mm") to Date type.
     */
    private Date convertStringToDate(String dateInString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        Date date;
        try {
            date = format.parse(dateInString);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This function converts a date from String ("Country/City" or "GMT Sign TwoDigitHours : Minutes") to TimeZone type.
     */
    private TimeZone convertStringToTimeZone(String timeZoneInString){
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneInString);
        return timeZone;
    }
}