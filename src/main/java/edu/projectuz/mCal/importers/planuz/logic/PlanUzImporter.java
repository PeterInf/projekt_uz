package edu.projectuz.mCal.importers.planuz.logic;

import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.planuz.logic.calendars.CalendarsListImporter;
import edu.projectuz.mCal.importers.planuz.logic.timetables.DepartmentsListImporter;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This is main clas of Plan UZ importer.
 * It allows you to import calendars and timetables
 * using {@link #importData()}.
 */
public class PlanUzImporter extends BaseEventImporter {

    private String name = "Plan UZ";
    private Elements allLinks;

    private CalendarsListImporter calendarsListImporter;
    private CalendarsList calendarsList;

    private DepartmentsListImporter departmentsListImporter;
    private DepartmentsList departmentsList;

    public PlanUzImporter() {
        super("http://plan.uz.zgora.pl/index.php", ImporterSourceType.WEB);
    }

    /**
     * @return Name of importer.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Imports data - calendars and timetables.
     */
    @Override
    public void importData() {
        Document homePageContent = Jsoup.parse(getSourceContent());
        allLinks = homePageContent.select(HtmlComponentName.ADDRESS);

        importCalendars();
        importTimetables();
    }

    private void importTimetables() {
        String timetablesUrl = getUrlByName(allLinks, "Plan grup");
        departmentsListImporter = new DepartmentsListImporter(timetablesUrl);
        departmentsList = departmentsListImporter.importDepartments();
    }

    private void importCalendars() {
        String calendarsUrl = getUrlByName(allLinks, "Kalendarze");
        calendarsListImporter = new CalendarsListImporter(calendarsUrl);
        calendarsList = calendarsListImporter.importCalendars();
    }

    private String getUrlByName(Elements allLinks, String urlName) {
        String urlBase = "http://plan.uz.zgora.pl/";
        for(Element link : allLinks) {
            if(link.text().equals(urlName)) {
                String resourceUrl = link.attr(HtmlComponentName.URL);
                return urlBase + resourceUrl;
            }
        }
        throw new IllegalArgumentException("Link with name " + urlName + "not found");
    }
}
