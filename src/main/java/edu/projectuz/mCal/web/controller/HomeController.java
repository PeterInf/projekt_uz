package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.exporters.csv.ConverterToCsvString;
import edu.projectuz.mCal.service.CalendarEventService;
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
    private CalendarEventService service;

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
        model.addAttribute("calendarEvent", new CalendarEvent());
        model.addAttribute("eventToRemoveInfo", new EventToRemoveInfo());
        model.addAttribute("calendarEvents", service.findAllCalendarEvent());
        return "home";
    }

    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@Valid @ModelAttribute("calendarEvent") CalendarEvent calendarEvent,
                                 Errors errors, Model model) {
        model.addAttribute("eventToRemoveInfo", new EventToRemoveInfo());
        if (errors.hasErrors()) {
            model.addAttribute("calendarEvents", service.findAllCalendarEvent());
            return "home";
        } else {
            service.saveCalendarEvent(calendarEvent);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/clearEvents", method = GET)
    public String clearEvents() {
        service.deleteAll();
        return "redirect:/";
    }

    @RequestMapping(value = "/removeEvent", method = GET)
    public String removeEvent(@ModelAttribute("eventToRemoveInfo") EventToRemoveInfo eventInfo) {
        service.deleteCalendarEventById(eventInfo.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "/generateCsv", method = GET)
    public void generateCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment;filename=events.csv");
        ServletOutputStream out = response.getOutputStream();

        ConverterToCsvString converter = new ConverterToCsvString();
        ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) service.findAllCalendarEvent();
        out.println(converter.convert(calendarEvents));
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/generateICal", method = GET)
    public void generateICal(HttpServletResponse response) throws IOException {
        response.setContentType("text/text");
        response.setHeader("Content-Disposition","attachment;filename=events.ical");
        ServletOutputStream out = response.getOutputStream();

        //TODO: use converter to iCal string
        out.println("");
        out.flush();
        out.close();
    }

}
