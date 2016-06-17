package edu.projectuz.mCal.importers.ICal.model;

import edu.projectuz.mCal.importers.ical.model.ICalEventAlarm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICalEventAlarmTest {

    private String action, alarmDesc, trigger;
    private ICalEventAlarm alarm;

    @Before
    public void setUp(){
        action = "a";
        alarmDesc = "d";
        trigger = "t";
        alarm = new ICalEventAlarm(action, alarmDesc, trigger);
    }

    @Test
    public void gettersTests(){
        assertNotNull(alarm);
        assertEquals(action, alarm.getAction());
        assertEquals(alarmDesc, alarm.getAlarmDescription());
        assertEquals(trigger, alarm.getTrigger());
    }

    @Test
    public void settersTests(){
        alarm.setAction(action);
        alarm.setAlarmDescription(alarmDesc);
        alarm.setTrigger(trigger);
    }
}
