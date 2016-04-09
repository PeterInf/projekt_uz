package edu.projectuz.mCal.importers.xml;

import edu.projectuz.mCal.helpers.DateHelper;
import edu.projectuz.mCal.core.models.CalendarEvent;
import edu.projectuz.mCal.importers.base.BaseEventImporter;
import edu.projectuz.mCal.importers.base.ImporterSourceType;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.io.StringReader;


public class XMLImporter extends BaseEventImporter{

    public XMLImporter(String sourcePath, ImporterSourceType sourceType) {
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
            String dateFormat = "yyyy-MM-dd";

            for (int i=0; i<nodeList.getLength(); i++) {

                CalendarEvent eventObject = new CalendarEvent();
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    eventObject.setStartDate(DateHelper.stringToDate(element.getElementsByTagName("dtstart").item(0).getTextContent().trim(),
                            dateFormat, DateHelper.stringToTimeZone(element.getElementsByTagName("tzid").item(0).getTextContent().trim())));
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


    @Override
    public String getName() {
        return "XML Importer";
    }

    @Override
    public void importData() {

    }
}

