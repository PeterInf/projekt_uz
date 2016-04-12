package edu.projectuz.mCal.importers.planuz.logic.calendars;

import edu.projectuz.mCal.importers.planuz.model.calendars.CalendarsList;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalendarsListImporterTest {

    @Test
    public void whenCalendarsImportedThenSizeMatches() {
        //Arrange
        CalendarsListImporter calendarsListImporter =
                new CalendarsListImporter("http://plan.uz.zgora.pl/kalendarze_lista.php");

        //Act
        CalendarsList calendarsList = calendarsListImporter.importCalendars();

        //Assert
        assertEquals(21, calendarsList.size());
    }

}
