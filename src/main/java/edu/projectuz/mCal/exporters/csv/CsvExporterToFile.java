package edu.projectuz.mCal.exporters.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvExporterToFile {

    public final File generateCsvFile(
            final String text,
            final String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
