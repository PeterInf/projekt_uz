package edu.projectuz.mCal.exporters.csv;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.csv.model.CSVSections;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExporter {

    private final String fileName;

    public CsvExporter(String fileName) {
        this.fileName = fileName;
    }

    public File generateCsvFile(ArrayList<CalendarEvent> listOfEvents) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            String separator = ",";
            String dateFormat = ("yyyy/MM/dd HH:mm");
            DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);

            fileWriter.append(CSVSections.TITLE);
            fileWriter.append(separator);
            fileWriter.append(CSVSections.DATE_START);
            fileWriter.append(separator);
            fileWriter.append(CSVSections.DATE_END);
            fileWriter.append(separator);
            fileWriter.append(CSVSections.DESCRIPTION);
            fileWriter.append(separator);
            fileWriter.append(CSVSections.TAG);
            fileWriter.append(separator);
            fileWriter.append(CSVSections.TIME_ZONE);
            fileWriter.append(System.lineSeparator());

            for (CalendarEvent calendarEvent : listOfEvents) {
                fileWriter.append(calendarEvent.getTitle());
                fileWriter.append(separator);
                fileWriter.append(calendarEvent.getStartDate().toString(formatter));
                fileWriter.append(separator);
                fileWriter.append(calendarEvent.getEndDate().toString(formatter));
                fileWriter.append(separator);
                fileWriter.append(calendarEvent.getDescription());
                fileWriter.append(separator);
                fileWriter.append(calendarEvent.getTag());
                fileWriter.append(separator);
                fileWriter.append(calendarEvent.getIdTimeZone());
                fileWriter.append(System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}