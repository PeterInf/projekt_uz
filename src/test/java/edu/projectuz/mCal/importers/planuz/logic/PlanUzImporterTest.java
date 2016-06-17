package edu.projectuz.mCal.importers.planuz.logic;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlanUzImporterTest {

    private PlanUzImporter planUzImporter;

    @Before
    public void setUp() {
        planUzImporter = new PlanUzImporter();
    }

    @Test
    public void whenInitializedThenNameMatches() {
        assertEquals("Plan UZ", planUzImporter.getName());
    }
}
