package edu.projectuz.mCal.importers.csv.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.csv.model.CSVSections;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class is main class for importer all data from CSV file.
 */
public class CSVImporter {

    /**
     * Wrap a BufferedReader around InputStreamReader and FileInputStream.
     */
    private BufferedReader fileReader;

    /**
     * Constructor sets the class member variables.
     *
     * @param filePath - the source file path.
     */
    public CSVImporter(String filePath) {
        try {
            this.fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is a main function of this class.
     * It is used to import all data from .csv file.
     *
     * @return Returned list of events.
     * @throws IOException on input error.
     */
    ArrayList<CalendarEvent> convertCsvToObject() throws IOException {
        String[] header = {"TITLE", "START", "END", "DESCRIPTION", "TAG", "TIMEZONE"};
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',').withHeader(header).withSkipHeaderRecord(true);
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();

        CSVParser parser;
        try {
            parser = new CSVParser(fileReader, format);
            for (CSVRecord csvRecord : parser) {
                CalendarEvent eventObject = new CalendarEvent();
                eventObject.setTitle(csvRecord.get(CSVSections.TITLE));
                eventObject.setStartDate(convertStringToDate(csvRecord.get(CSVSections.DATE_START)));
                eventObject.setEndDate(convertStringToDate(csvRecord.get(CSVSections.DATE_END)));
                eventObject.setDescription(csvRecord.get(CSVSections.DESCRIPTION));
                eventObject.setTag(csvRecord.get(CSVSections.TAG));
                eventObject.setTimeZone(convertStringToTimeZone(csvRecord.get(CSVSections.TIME_ZONE)));
                listOfEvents.add(eventObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //noinspection ThrowFromFinallyBlock
            fileReader.close();
        }
        return listOfEvents;
    }

    /**
     * This function converts a date from String ("yyyy/MM/dd hh:mm") to Date type.
     *
     * @param dateInString Date in String format from file.
     * @return Returned the date of the start or end of the event.
     * @throws Exception Missing date in .csv.
     */
    private Date convertStringToDate(String dateInString) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        Date date;
        try {
            date = format.parse(dateInString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new IOException("Missing date.");
    }

    /**
     * This function converts a date from String ("Country/City" or "GMT Sign TwoDigitHours : Minutes") to TimeZone type.
     *
     * @param timeZoneInString Timezone in String format from file.
     * @return Returned the time zone of the event.
     */
    private TimeZone convertStringToTimeZone(String timeZoneInString) {
        return TimeZone.getTimeZone(timeZoneInString);
    }
}