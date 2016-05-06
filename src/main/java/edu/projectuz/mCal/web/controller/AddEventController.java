package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AddEventController {
    private CalendarEventRepository calendarEventRepository;

    @Autowired
    public AddEventController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

//    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@ModelAttribute("SpringWeb") CalendarEvent calendarEvent, Model model) {
//        model.addAttribute("calendarEvent", calendarEvent);
        model.addAttribute("title", calendarEvent.getTitle());
        model.addAttribute("tag", calendarEvent.getTag());
        return "event";
    }
}
