package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.csv.logic.CSVImporter;
import edu.projectuz.mCal.importers.ical.logic.ICalImporter;
import edu.projectuz.mCal.importers.xml.XMLImporter;
import edu.projectuz.mCal.service.CalendarEventService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

@Controller
public class ImportFromFile {

    @Autowired
    private CalendarEventService service;

    /**
     * Upload single file using Spring Controller
     * @param file file.
     * @return string.
     */
    @RequestMapping(value = "/importFromFile", method = RequestMethod.POST)
    public String importFromFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                importToDatabase(serverFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/";
    }

    private void importToDatabase(File serverFile) throws Exception {
        ArrayList<CalendarEvent> events = new ArrayList<>();
        String extension = FilenameUtils.getExtension(serverFile.getAbsolutePath());

        switch (extension) {
            case "csv":
                CSVImporter csvImporter = new CSVImporter(serverFile.getAbsolutePath(), ImporterSourceType.FILE);
                events = csvImporter.convertCsvToObject();
                break;
            case "xml":
                XMLImporter xmlImporter = new XMLImporter(serverFile.getAbsolutePath(), ImporterSourceType.FILE);
                events = xmlImporter.convertToObject();
                break;
            case "ics":
                ICalImporter iCalImporter = new ICalImporter(serverFile.getAbsolutePath(), ImporterSourceType.FILE);
                events = iCalImporter.convertICalToObject();
                break;
        }

        service.saveCalendarEventsList(events);
    }

}
