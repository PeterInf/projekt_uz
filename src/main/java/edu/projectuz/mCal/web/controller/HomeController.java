package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.exporters.csv.ConverterToCsvString;
import edu.projectuz.mCal.exporters.ical.ICalExporter;
import edu.projectuz.mCal.importers.planuz.logic.PlanUzImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.Department;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import edu.projectuz.mCal.service.CalendarEventService;
import edu.projectuz.mCal.service.PlanUzService;
import edu.projectuz.mCal.web.EventToRemoveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public final class HomeController {

    private HomeController() {}

    @Autowired
    private CalendarEventService calendarService;

    @Autowired
    private PlanUzService planUzService;

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
        model.addAttribute("calendarEvent", new CalendarEvent());
        model.addAttribute("eventToRemoveInfo", new EventToRemoveInfo());
        model.addAttribute("calendarEvents", calendarService.findAllCalendarEvent());
        addDepartmentsList(model);
        return "home";
    }

    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@Valid @ModelAttribute("calendarEvent") CalendarEvent calendarEvent,
                                 Errors errors, Model model) {
        model.addAttribute("eventToRemoveInfo", new EventToRemoveInfo());
        if (errors.hasErrors()) {
            model.addAttribute("calendarEvents", calendarService.findAllCalendarEvent());
            return "home";
        } else {
            calendarService.saveCalendarEvent(calendarEvent);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/clearEvents", method = GET)
    public String clearEvents() {
        calendarService.deleteAll();
        return "redirect:/";
    }

    @RequestMapping(value = "/removeEvent", method = GET)
    public String removeEvent(@ModelAttribute("eventToRemoveInfo") EventToRemoveInfo eventInfo) {
        calendarService.deleteCalendarEventById(eventInfo.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "/generateCsv", method = GET, produces = "text/csv;charset=UTF-8")
    public void generateCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition","attachment;filename=events.csv");

        ConverterToCsvString converter = new ConverterToCsvString();
        ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) calendarService.findAllCalendarEvent();

        try (ServletOutputStream out = response.getOutputStream()) {
            out.write(converter.convert(calendarEvents).getBytes("UTF-8"));
        }
    }

    @RequestMapping(value = "/generateICal", method = GET, produces = "text/ics;charset=UTF-8")
    public void generateICal(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition","attachment;filename=events.ics");

        ICalExporter converter = new ICalExporter();
        ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) calendarService.findAllCalendarEvent();

        try (ServletOutputStream out = response.getOutputStream();) {
            out.write(converter.generateICal(calendarEvents).getBytes("UTF-8"));
        }
    }

    private void addDepartmentsList(Model model) {
        DepartmentsList departmentsList = planUzService.getAllTimetables();
        if (departmentsList == null) {
            model.addAttribute("departmentsList", new ArrayList<Department>());
        } else {
            model.addAttribute("departmentsList", planUzService.getAllTimetables().getDepartmentsList());
        }
    }

}
