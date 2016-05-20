package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.service.CalendarEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    private CalendarEventService calendarEventService;


    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
        model.addAttribute("calendarEvent", new CalendarEvent());
        model.addAttribute("calendarEvents", calendarEventService.findAllCalendarEvent());
        return "home";
    }

    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@ModelAttribute("calendarEvent") CalendarEvent calendarEvent, Model model) {
        calendarEventService.saveCalendarEvent(calendarEvent);
        return "redirect:/";
    }

    @RequestMapping(value = "/clearEvents", method = GET)
    public String clearEvents() {
        return "redirect:/";
    }
}
