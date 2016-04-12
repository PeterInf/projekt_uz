package edu.projectuz.mCal.importers.ical.logic;

import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;


public class ICalImporter extends BaseEventImporter {

    protected ICalImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
    }

    @Override
    public String getName() {
        return "ICalImporter";
    }

    @Override
    public void importData() {

    }

    public void GetContetnt(){
        
    }


}
