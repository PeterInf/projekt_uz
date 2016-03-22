package edu.projectuz.importers.csv.resourcestmp;

import edu.projectuz.importers.csv.logic.CSVImporter;

import java.io.IOException;

public class StarterOnlyForTest {
    public static void main(String[] args) throws IOException {
        System.out.println(new CSVImporter("C:/Users/sledzik_23/Desktop/goo.csv").convertCsvToObject());
    }
}