package edu.projectuz.mCal.importers.ical.logic;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * This class is main class for importer all data from ICal.
 */
public class ICalImporter extends BaseEventImporter {

    /**
     * @param sourcePath specifies the path of the file.
     * @param sourceType specifies the type of resource {@link ImporterSourceType}.
     */

    public ICalImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
    }
    private String dateFormat = "yyyyMMddHHmmss";

    /**
     * This method return name importer.
     */
    @Override
    public String getName() {
        return "ICalImporter";
    }

    @Override
    public void importData() {

    }

/**
 * This is a main function of this class.
 * It is used to import all data from ICal.
 *
 * @return Returned list of events.
 * */
    public ArrayList<CalendarEvent> convertICalToObject() throws Exception {
        Calendar calendar = buildCalendar();
        ArrayList<VEvent> vevents = calendar.getComponents(Component.VEVENT);
        ArrayList<CalendarEvent> events = new ArrayList<>();
            for (VEvent ev : vevents) {
                CalendarEvent event = new CalendarEvent();
                event.setStartDate(DateHelper.stringToDate(ICalHelper.getGroupFromDate(ev.getStartDate().toString(), ICalRegexSections.DATE) +
                        ICalHelper.getGroupFromDate(ev.getStartDate().toString(),  ICalRegexSections.TIME), dateFormat));
                event.setEndDate(DateHelper.stringToDate(ICalHelper.getGroupFromDate(ev.getEndDate().toString(),  ICalRegexSections.DATE) +
                        ICalHelper.getGroupFromDate(ev.getEndDate().toString(), ICalRegexSections.TIME), dateFormat));
                event.setTitle(ev.getDescription().getValue());
                event.setDescription(ev.getDescription().getValue());
                event.setTimeZone(DateHelper.stringToTimeZone(ICalHelper.getGroupFromDate(ev.getEndDate().toString(), ICalRegexSections.TIMEZONE)));
                event.setTag("");
                events.add(event);
            }
        return events;
    }

    /**
     * This is a private function of this class.
     * It is used to build calendar.
     *
     * @return Returned calendar.
     * */
    private Calendar buildCalendar(){
        InputStream is = new ByteArrayInputStream(getSourceContent().getBytes());
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = null;
        try {
            calendar = builder.build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

}