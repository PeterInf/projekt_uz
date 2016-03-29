package edu.projectuz.importers.planuz.logic.timetables;

/**
 * This class stores information about indexes of different components
 * that are using when it comes to importing Timetables.
 * Using this descriptive names instead of numbers improves readability of the code.
 */
class TimetableComponentIndex {
    /**
     * Names of indexes with their values.
     */
    static final int NAME_NODE = 0,
                            GROUPS_TABLE = 1,
                            ROW_WITH_HEADERS = 0,
                            NULL_ELEMENT = 0,
                            SUBGROUP = 0,
                            START_TIME = 1,
                            END_TIME = 2,
                            CLASS_NAME = 3,
                            CLASS_TYPE = 4,
                            TEACHER_NAME = 5,
                            ROOM = 6,
                            DAYS = 7;
}
