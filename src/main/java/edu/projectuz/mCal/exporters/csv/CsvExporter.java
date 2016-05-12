package edu.projectuz.mCal.exporters.csv;

import edu.projectuz.mCal.core.models.CalendarEvent;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExporter {

    private final String fileName;

    public CsvExporter(String fileName) {
        this.fileName = fileName;
    }

    public void generateCsvFile(ArrayList<CalendarEvent> listOfEvents) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            String separator = ",";
            String dateFormat = ("yyyy/MM/dd HH:mm");
            DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);

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
    }
}