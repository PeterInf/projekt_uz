package edu.projectuz.mCal.importers.url.model;

/**
 * Represents a mapping from a column in a table on web page, for class URLImporter.
 */
public final class URLSections {

    private URLSections() {

    }

    public static final int TITLE = 0,
            DATE_START = 1,
            DATE_END = 2,
            DESCRIPTION = 3,
            TAG = 4,
            TIME_ZONE = 5;
}
