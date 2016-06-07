package edu.projectuz.mCal.service;

import edu.projectuz.mCal.dao.PlanUzDao;
import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import edu.projectuz.mCal.importers.planuz.model.timetables.DepartmentsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("planUzService")
@Transactional
public class PlanUzServiceImpl implements PlanUzService {

    @Autowired
    private PlanUzDao dao;

    public void saveCalendarsList(CalendarsList calendarsList) {
        dao.saveCalendarsList(calendarsList);
    }

    public void saveTimetables(DepartmentsList departmentsList) {
        dao.saveTimetables(departmentsList);
    }

    public DepartmentsList getAllTimetables() {
        return dao.getAllTimetables();
    }
}
