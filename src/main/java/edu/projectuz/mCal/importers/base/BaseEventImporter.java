package edu.projectuz.mCal.importers.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.net.URL;

/**
 * Base class for importers which read data from specified source.
 */
public abstract class BaseEventImporter implements EventImporter {

    private final Logger logger = LogManager.getLogger(BaseEventImporter.class);
    private final String sourceContent;

    protected BaseEventImporter(final String sourcePath,
                                final ImporterSourceType sourceType) {
        String startLog = String.format(
                "Start importer %s with data [sourcePath=%s sourceType=%s]",
                getName(), sourcePath, sourceType);
        logger.debug(startLog);
        sourceContent = getDataFromSource(sourcePath, sourceType);
    }

    /**
     * @return Name of importer
     */
    public abstract String getName();

    /**
     * @return Content of imported file
     */
    protected final String getSourceContent() {
        return sourceContent;
    }

    /**
     * Method import data from file to database.
     * Every imported has own implementation of this method.
     */
    public abstract void importData();

    private BufferedReader getReader(final String sourcePath,
                                     final ImporterSourceType sourceType)
            throws Exception {
        logger.debug(String.format(
                "Trying to create reader for importer %s", getName()));

        switch (sourceType) {
            case FILE:
                try {
                    return new BufferedReader(new InputStreamReader(
                            new FileInputStream(sourcePath), "UTF-8"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
                break;
            case WEB:
                try {
                    URL fileUrl = new URL(sourcePath);
                    return new BufferedReader(
                            new InputStreamReader(fileUrl.openStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
                break;
            default:
                break;
        }

        throw new Exception(
                "Cannot create buffered reader with provided data");
    }

    private String getDataFromSource(final String sourcePath,
                                     final ImporterSourceType sourceType) {
        BufferedReader reader;
        StringBuilder builder = new StringBuilder();
        logger.debug(String.format(
                "Start read file from source: %s", sourcePath));

        try {

            String currentLine;
            reader = getReader(sourcePath, sourceType);

            while ((currentLine = reader.readLine()) != null) {
                builder.append(currentLine + System.lineSeparator());
            }

            logger.debug(String.format("Close reader: %s", sourcePath));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return builder.toString();
    }
}
