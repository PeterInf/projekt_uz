package edu.projectuz.mCal.importers.planuz.logic;

/**
 * This class represents HTML components used by planUzImporter.
 * Each component's name has it's corresponding HTML tag (String value).
 * Using this names instead of tags improves readability of the code.
 * For example you can use HtmlComponentName.COLUMN instead of "td" which makes more sense.
 */
public class HtmlComponentName {

    /**
     * Names of components with their HTML tags.
     */
    public static final String  TABLE = "table",
                                HEADER = "h3",
                                ROW = "tr",
                                COLUMN = "td",
                                ADDRESS = "a",
                                ABSOLUTE_URL = "abs:href",
                                URL = "href",
                                BOLD_TEXT = "b",
                                LIST = "ul";
}
