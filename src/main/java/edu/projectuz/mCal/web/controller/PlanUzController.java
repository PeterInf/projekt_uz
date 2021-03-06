package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.importers.planuz.PlanUzConverter;
import edu.projectuz.mCal.importers.planuz.logic.PlanUzImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.*;
import edu.projectuz.mCal.service.CalendarEventService;
import edu.projectuz.mCal.service.PlanUzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlanUzController {

    @Autowired
    private PlanUzService service;

    @Autowired
    private CalendarEventService calendarService;

    @RequestMapping(value = "/updateDatabase")
    public final String updateDatabase() throws Exception {
        PlanUzImporter importer = new PlanUzImporter();
        CalendarsList calendarsList = importer.getCalendarsList();
        DepartmentsList departmentsList = importer.getDepartmentsList();

        service.saveCalendarsList(calendarsList);
        service.saveTimetables(departmentsList);
        return "redirect:/";
    }

    @RequestMapping(value = "/importGroup/{groupName:.+}", method= RequestMethod.GET)
    public String importGroup(@PathVariable String groupName, Model model) {
        GroupTimetable groupTimetable = service.getGroupTimetable(groupName);
        PlanUzConverter planUzConverter = new PlanUzConverter(service.getCalendarsList());
        calendarService.saveCalendarEventsList(planUzConverter.convertTimetable(groupTimetable));
        return "redirect:/";
    }
}
