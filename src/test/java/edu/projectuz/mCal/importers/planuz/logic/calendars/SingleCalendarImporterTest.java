package edu.projectuz.mCal.importers.planuz.logic.calendars;

import edu.projectuz.mCal.importers.planuz.model.calendars.Calendar;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SingleCalendarImporterTest {

    private SingleCalendarImporter singleCalendarImporter;

    @Test
    public void whenCalendarImportedThenNumberOfItemsMatch() throws Exception {
        //Arrange
        SingleCalendarImporter singleCalendarImporter =
                new SingleCalendarImporter("D", "Studia stacjonarne",
                "http://plan.uz.zgora.pl/kalendarze_lista_szczegoly.php?pId_kalendarz=1612");

        //Act
        Calendar calendar = singleCalendarImporter.importCalendar();

        //Assert
        assertEquals(75, calendar.getDaysListByType("D - Studia stacjonarne").size());
        assertEquals(40, calendar.getDaysListByType("DI - Studia stacjonarne I-sza połowa sem.").size());
    }

}
