package edu.projectuz.mCal.helpers;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class DateHelperTest {

    @Test
    public void convertStringToDate() throws Exception {
        //Arrange
        String dateText = "04-08-1994 12:44:33";
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Warsaw");
        String dateFormat = "dd-mm-yyyy HH:mm:ss";

        Calendar cal = Calendar.getInstance();
        cal.set(1994, Calendar.JANUARY, 4, 12, 44, 33); //Year, month, day of month, hours, minutes and seconds
        Date expected = cal.getTime();

        //Act
        Date result = DateHelper.stringToDate(dateText, dateFormat, timeZone);

        //Assert
        assertEquals(expected.toString(), result.toString());
    }
}