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

    @Test(expected = ParseException.class)
    @Parameters({
            "1994-08-04,dd-mm-yyyy,Europe/Warsaw",
    })
    public void convertStringToDateParseException(String dateText, String dateFormat, String timezoneText) throws Exception {
        //Arrange
        TimeZone timeZone = TimeZone.getTimeZone(timezoneText);

        //Act
        Date result = DateHelper.stringToDate(dateText, dateFormat, timeZone);
    }


    public void convertStringToDateNullArgument() throws Exception {
        //Arrange
        String dateText = "";
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Warsaw");
        String dateFormat = "dd-mm-yyyy HH:mm:ss";

        Calendar cal = Calendar.getInstance();
        cal.set(1994, Calendar.JANUARY, 4, 12, 44, 33); //Year, month, day of month, hours, minutes and seconds
        Date expected = cal.getTime();

        //Act
        Date result = DateHelper.stringToDate(dateText, dateFormat, timeZone);

    }

}