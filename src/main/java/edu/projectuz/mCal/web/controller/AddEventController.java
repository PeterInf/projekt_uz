package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("edu.projectuz.mCal")
public class AddEventController {
    private CalendarEventRepository calendarEventRepository;

    @Autowired
    public AddEventController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @RequestMapping(value = "/addEvent", method = GET)
    public String processAddEvent(@Validated CalendarEvent calendarEvent, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/event/error";
        }
        return "redirect:/event/";
    }
}
