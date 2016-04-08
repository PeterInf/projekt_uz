package edu.projectuz.mCal.importers.xml;

import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.util.TimeZone;

public class XMLImporter extends BaseEventImporter{

    //private File file;

    protected XMLImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
    }

    public ArrayList<CalendarEvent> convertToObject()
    {
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<CalendarEvent>();

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(getSourceContent())));

            NodeList nodeList = document.getElementsByTagName("vevent");

            for (int i=0; i<nodeList.getLength(); i++) {

                CalendarEvent eventObject = new CalendarEvent();
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    //System.out.println("dtstamp :" + element.getElementsByTagName("dtstamp").item(0).getTextContent());
                    //System.out.println("dtstart : " + element.getElementsByTagName("dtstart").item(0).getTextContent());
                    //System.out.println("summary : " + element.getElementsByTagName("summary").item(0).getTextContent());
                    eventObject.setStartDate(convertStringToDate(element.getElementsByTagName("dtstart").item(0).getTextContent().trim()));
                    eventObject.setDescription(element.getElementsByTagName("summary").item(0).getTextContent().trim());
                    listOfEvents.add(eventObject);

                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return listOfEvents;
    }

    public Date convertStringToDate(String dateInString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = format.parse(dateInString);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return "XML Importer";
    }

    @Override
    public void importData() {

    }
}

