package edu.projectuz.mCal.importers.csv.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.csv.model.CSVSections;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is main class for importer all data from CSV file.
 */
public class CSVImporter extends BaseEventImporter {

    /**
     * @param sourcePath
     * @param sourceType
     */
    protected CSVImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
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
        String dateFormat = "yyyy/MM/dd hh:mm";
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',').withHeader(header).withSkipHeaderRecord(true);
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();

        CSVParser parser;
        try {
            parser = new CSVParser(new StringReader(getSourceContent()), format);
            for (CSVRecord csvRecord : parser) {
                CalendarEvent eventObject = new CalendarEvent();
                eventObject.setTitle(csvRecord.get(CSVSections.TITLE));
                eventObject.setStartDate(DateHelper.stringToDate(csvRecord.get(CSVSections.DATE_START),
                        dateFormat, DateHelper.stringToTimeZone(csvRecord.get(CSVSections.TIME_ZONE))));
                eventObject.setEndDate(DateHelper.stringToDate(csvRecord.get(CSVSections.DATE_END),
                        dateFormat, DateHelper.stringToTimeZone(csvRecord.get(CSVSections.TIME_ZONE))));
                eventObject.setDescription(csvRecord.get(CSVSections.DESCRIPTION));
                eventObject.setTag(csvRecord.get(CSVSections.TAG));
                eventObject.setTimeZone(DateHelper.stringToTimeZone(csvRecord.get(CSVSections.TIME_ZONE)));
                listOfEvents.add(eventObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfEvents;
    }

    @Override
    public String getName() {
        return "CSV";
    }

    @Override
    public void importData() {

    }
}