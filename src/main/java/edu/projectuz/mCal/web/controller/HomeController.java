package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.ArrayListEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {

    @Autowired
    private ArrayListEventsRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("calendarEvent", new CalendarEvent());
        return "home";
    }

    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@ModelAttribute("calendarEvent") CalendarEvent calendarEvent, Model model) {
        repository.create(calendarEvent);
        model.addAttribute("calendarEvents", repository.getAll());
        return "home";
    }
}
