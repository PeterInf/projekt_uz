package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.dao.PlanUzDao;
import edu.projectuz.mCal.importers.planuz.logic.PlanUzImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.mCal.service.CalendarEventService;
import edu.projectuz.mCal.service.PlanUzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlanUzController {

    @Autowired
    private PlanUzService service;

    @RequestMapping(value = "/updateDatabase")
    public String updateDatabase() throws Exception {
        PlanUzImporter importer = new PlanUzImporter();
        CalendarsList calendarsList = importer.getCalendarsList();
//        DepartmentsList departmentsList = importer.getDepartmentsList();
        System.out.println("Zaczynam");
        service.saveCalendarsList(calendarsList);
//        service.addTimetables(departmentsList);
        System.out.println("Dzialam");
        return "redirect:/";
    }
}
