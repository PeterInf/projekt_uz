package edu.projectuz.mCal.importers.planuz.logic.calendars;

/**
 * This class stores information about indexes of different components
 * that are using when it comes to importing Calendars.
 * Using this descriptive names instead of numbers
 * improves readability of the code.
 */
final class CalendarComponentIndex {

    private CalendarComponentIndex() {

    }

    /**
     * Names of indexes with their values.
     */
    static final int TITLE_HEADER = 0,
            CALENDARS_TABLE = 1,
            FIRST_ROW_WITH_CALENDARS = 1,
            NAME_COLUMN = 0,
            DESCRIPTION_COLUMN = 1,
            SECOND_TABLE_NAME = 4,
            FIRST_TABLE_WITH_DAYS = 0,
            FIRST_ROW_WITH_DAYS = 1,
            TABLE_WITHOUT_DAYS = 0,
            DAY_NUMBER_COLUMN = 0,
            DAY_DATE_COLUMN = 1,
            TIMETABLE_DAY_COLUMN = 2,
            CALENDAR_DAY_COLUMN = 3;
}
