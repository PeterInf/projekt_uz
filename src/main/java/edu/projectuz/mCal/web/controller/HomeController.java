package edu.projectuz.mCal.web.controller;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.dao.ArrayListEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @Autowired
    private ArrayListEventsRepository repository;

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
        model.addAttribute("calendarEvent", new CalendarEvent());
        model.addAttribute("calendarEvents", repository.getAll());
        return "home";
    }

    @RequestMapping(value = "/addEvent", method = POST)
    public String addEventSubmit(@Valid @ModelAttribute("calendarEvent") CalendarEvent calendarEvent, Errors errors) {
        if (errors.hasErrors()) {
            return "home";
        } else {
            repository.create(calendarEvent);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/clearEvents", method = GET)
    public String clearEvents() {
        repository.deleteAll();
        return "redirect:/";
    }
}
