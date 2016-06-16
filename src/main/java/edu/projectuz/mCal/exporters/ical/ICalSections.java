package edu.projectuz.mCal.exporters.ical;

/**
 * Represents a mapping from a column in a ICalExporter, for class ICalExporter.
 */

public final class ICalSections {

    private ICalSections() {

    }

    public static final String TITLE = "TITLE",
            DATE_START = "DTSTART",
            DATE_END = "DTEND",
            DESCRIPTION = "DESCRIPTION",
            TAG = "TAG",
            BEGIN = "BEGIN:",
            END = "END:",
            VCALENDAR = "VCALENDAR",
            SUMMARY = "SUMMARY:",
            VEVENT = "VEVENT",
            COLONSEPARATOR = ":",
            TSEPARATOR = "T";
}
