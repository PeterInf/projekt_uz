package edu.projectuz.mCal.helpers;

import junitparams.JUnitParamsRunner;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class DateHelperTest {

    @Test
    public void convertStringToDate() throws Exception {
        //Arrange
        String dateText = "04-08-1994 12:44:33";
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        String dateFormat = "dd-mm-yyyy HH:mm:ss";

        DateTime expected = new DateTime(DateTimeFormat.forPattern(dateFormat).withZone(DateTimeZone.forTimeZone(timeZone)).parseDateTime(dateText));
        DateTime expected2 = new DateTime(DateTimeFormat.forPattern(dateFormat).parseDateTime(dateText));

        //Act
        DateTime result = DateHelper.stringToDate(dateText, dateFormat, timeZone);
        DateTime result2 = DateHelper.stringToDate(dateText, dateFormat);

        //Assert
        assertEquals(expected.toString(), result.toString());
        assertEquals(expected2.toString(), result2.toString());

        assertNotNull(new DateHelper());
    }
}