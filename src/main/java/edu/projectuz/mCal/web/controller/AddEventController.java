package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.CalendarEventRepository;
import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("edu.projectuz.mCal")
public class AddEventController {
    private CalendarEventRepository calendarEventRepository;

    @Autowired
    public AddEventController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @RequestMapping(value = "/calendar", method = POST)
    public String processAddEvent(
            @Validated CalendarEvent calendarEvent, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        calendarEventRepository.create(calendarEvent);
        return "redirect:/edu.projectuz.mCal/" + calendarEvent.getTitle();
    }

    @RequestMapping(value = "/calendar", method = GET)
    public String processDeleteEvent(
            @Validated CalendarEvent calendarEvent, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        calendarEventRepository.create(calendarEvent);
        return "redirect:/edu.projectuz.mCal/" + calendarEvent.getTitle();
    }
}
