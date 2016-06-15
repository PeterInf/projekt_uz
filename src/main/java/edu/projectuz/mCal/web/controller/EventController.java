package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    @Autowired
    private CalendarEventService service;

    @RequestMapping(value = "/event/{id}")
    public String showEvent(@PathVariable int id, Model model) {
        CalendarEvent calendarEvent = service.findById(id);
        if (calendarEvent == null) {
            model.addAttribute("id", id);
            return "eventNotFound";
        } else {
            model.addAttribute("calendarEvent", calendarEvent);
            return "event";
        }
    }
}
