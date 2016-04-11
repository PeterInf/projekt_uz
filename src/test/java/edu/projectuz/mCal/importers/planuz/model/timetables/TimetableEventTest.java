package edu.projectuz.mCal.importers.planuz.model.timetables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimetableEventTest {

    private TimetableEvent timetableEvent;

    @Before
    public void setUp() {
        timetableEvent = new TimetableEvent("A", "16:55", "18:25",
                "Programowanie współbieżne i rozproszone", "L",
                "dr inż. Tomasz Gratkowski", "207 A-2", "D/");
    }

    @Test
    public void whenInitializedThenNotNull() {
        assertTrue(timetableEvent != null);
    }

    @Test
    public void whenConvertedToStringThenMatchPattern() {
        String timetableEventConvertedToString = "TimetableEvent{" +
                "subgroup='" + "A" + '\'' +
                ", startTime='" + "16:55" + '\'' +
                ", endTime='" + "18:25" + '\'' +
                ", eventName='" + "Programowanie współbieżne i rozproszone" + '\'' +
                ", eventType='" + "L" + '\'' +
                ", teacherName='" + "dr inż. Tomasz Gratkowski" + '\'' +
                ", room='" + "207 A-2" + '\'' +
                ", days='" + "D/" + '\'' +
                '}';

        assertEquals(timetableEventConvertedToString, timetableEvent.toString());
    }
}
