package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.csv.logic.CSVImporter;
import edu.projectuz.mCal.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

                CSVImporter csvImporter = new CSVImporter(serverFile.getAbsolutePath(), ImporterSourceType.FILE);
                ArrayList<CalendarEvent> events = csvImporter.convertCsvToObject();

                for(CalendarEvent event : events) {
                    service.saveCalendarEvent(event);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/";
    }
}
