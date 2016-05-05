package edu.projectuz.mCal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String event(){
        return "event";
    }
}
