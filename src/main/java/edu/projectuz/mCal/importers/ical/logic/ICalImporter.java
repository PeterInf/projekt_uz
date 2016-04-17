package edu.projectuz.mCal.importers.ical.logic;

import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import edu.projectuz.mCal.importers.ical.model.ICalModel;
import net.fortuna.ical4j.data.CalendarParserImpl;
import net.fortuna.ical4j.data.HCalendarParser;

import javax.annotation.Resource;
import java.io.File;


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
        //
    }


}
