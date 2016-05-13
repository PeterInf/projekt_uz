package edu.projectuz.mCal.importers.ICal.logic;

import edu.projectuz.mCal.importers.ical.logic.ICalHelper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICalHelperTest {
    @Test
    public void getGroupFromDateEmpty() throws Exception {
        assertEquals("", ICalHelper.getGroupFromDate("", ""));
    }

}