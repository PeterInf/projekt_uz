package edu.projectuz.mCal.importers.xml;

import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.io.StringReader;

/**
 * This class import all data from XML file.
 */
public class XMLImporter extends BaseEventImporter{

    private final Logger logger = LogManager.getLogger(XMLImporter.class);

    /**
     * @param sourcePath specifies the path of the file.
     * @param sourceType specifies the type of resource {@link ImporterSourceType}.
     */
    public XMLImporter(String sourcePath, ImporterSourceType sourceType) {
        super(sourcePath, sourceType);
    }

    /**
     * This is a main function of this class.
     * It is used to import all data from .xml file.
     *
     * @return Returned list of events
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    public ArrayList<CalendarEvent> convertToObject() throws Exception
    {
        String dateFormat = "yyyy/MM/dd HH:mm";
        ArrayList<CalendarEvent> listOfEvents = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(getSourceContent())));
            NodeList nodeList = document.getElementsByTagName("vevent");

            for (int i=0; i<nodeList.getLength(); i++) {
                helperForParser(nodeList, listOfEvents, dateFormat, i);
            }

        } catch (IllegalArgumentException e) {
            logger.debug(e.getMessage());
            throw new IllegalArgumentException();
        } catch (IOException e){
            logger.debug(e.getMessage());
            throw new IndexOutOfBoundsException();
        }
        return listOfEvents;
    }

    /**
     * Simple helper method for parsing.
     *
     * @param nodeList     list of nodes from xml file.
     * @param listOfEvents list of calendar events.
     * @param dateFormat   date format.
     * @param i            loop counter variable.
     */
    private void helperForParser(NodeList nodeList, ArrayList<CalendarEvent> listOfEvents, String dateFormat, int i) {
        CalendarEvent eventObject = new CalendarEvent();
        Node node = nodeList.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            mapElements(dateFormat, eventObject, element);
            listOfEvents.add(eventObject);
        }
    }

    /**
     * This method gets xml elements by name and sets them into calendar event object.
     *
     * @param dateFormat   date format.
     * @param eventObject  single calendar event object.
     * @param element      single element of a node.
     */
    private void mapElements(String dateFormat, CalendarEvent eventObject, Element element) {
        eventObject.setTitle(element.getElementsByTagName("summary").item(0).getTextContent().trim());
        eventObject.setStartDate(DateHelper.stringToDate(element.getElementsByTagName("dtstart").item(0).getTextContent().trim(),
                dateFormat, DateHelper.stringToTimeZone(element.getElementsByTagName("tzid").item(0).getTextContent().trim())));
        eventObject.setEndDate(DateHelper.stringToDate(element.getElementsByTagName("dtend").item(0).getTextContent().trim(),
                dateFormat, DateHelper.stringToTimeZone(element.getElementsByTagName("tzid").item(0).getTextContent().trim())));
        eventObject.setDescription(element.getElementsByTagName("description").item(0).getTextContent().trim());
        eventObject.setTag(element.getElementsByTagName("tag").item(0).getTextContent().trim());
        eventObject.setTimeZone(DateHelper.stringToTimeZone(element.getElementsByTagName("tzid").item(0).getTextContent().trim()));
    }

    /**
     * @return Name of importer.
     */
    @Override
    public String getName() {
        return "XML Importer";
    }

    @Override
    public void importData() {
    }
}

