package edu.projectuz.mCal.importers.ical.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.ical.model.ICalModel;
import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarParserImpl;
import net.fortuna.ical4j.data.HCalendarParser;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Location;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ICalImporter extends BaseEventImporter {

    protected ICalImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
    }
    public ICalModel iCalModel = new ICalModel();
    private CalendarParserImpl Parser = new CalendarParserImpl();
    @Override
    public String getName() {
        return "ICalImporter";
    }

    @Override
    public void importData() {

    }

    public void getContent(){

    }

    public ArrayList<CalendarEvent> getCalendarEventList() {
        InputStream is = new ByteArrayInputStream(getSourceContent().getBytes());
        CalendarBuilder builder = new CalendarBuilder();
        net.fortuna.ical4j.model.Calendar calendar = null;
        try {
            calendar = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        }
        ArrayList<VEvent> vevents = calendar.getComponents(Component.VEVENT);
        ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
        for (VEvent ev : vevents){
            CalendarEvent event = new CalendarEvent();
            //event.setStartDate() // tutaj data
            //event.setEndDate() // tutaj tysz
            event.setTitle(ev.getName());//not sure
            event.setDescription(ev.getDescription().getValue());
            //event.setTimeZone()//;c
            events.add(event);
        }


        return events;
    }
}