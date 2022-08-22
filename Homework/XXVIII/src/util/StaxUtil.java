package util;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;

public class StaxUtil {
    public static void serializeTrianglesStax(List<Triangle> triangles, String path) throws Exception{
        XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(path + "/Triangles.xml"));

        xmlWriter.writeStartDocument();
        xmlWriter.writeStartElement("Triangles");

        for(var triangle : triangles) {
            xmlWriter.writeStartElement("Triangle");

            for(var field : triangle.getClass().getDeclaredFields()){

                field.setAccessible(true);

                xmlWriter.writeStartElement(field.getName());
                xmlWriter.writeCharacters(String.valueOf(field.get(triangle)));
                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();

        xmlWriter.flush();
        xmlWriter.close();
    }

    public static List<Rectangle> deserializeRectanglesStax(String path) throws Exception{
        boolean isWidthEvent = false, isHeightEvent = false;

        XMLEventReader eventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileReader(path));
        
        List<Rectangle> rectangles = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        
        while(eventReader.hasNext()){
            XMLEvent event = eventReader.nextEvent();
            
            switch(event.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = event.asStartElement().getName().getLocalPart();
                    
                    if(elementName.equalsIgnoreCase("rectangle")){
                        rectangle = new Rectangle();
                    }
                    if(elementName.equalsIgnoreCase("width")){
                        isWidthEvent = true;
                    }
                    if(elementName.equalsIgnoreCase("height")){
                        isHeightEvent = true;
                    }
                break;
                
                case XMLStreamConstants.CHARACTERS:
                    Characters fieldValue = event.asCharacters();

                    if(isWidthEvent){
                        rectangle.setWidth(Integer.valueOf(fieldValue.getData()));

                        isWidthEvent = false;
                    }

                    if(isHeightEvent){
                        rectangle.setHeight(Integer.valueOf(fieldValue.getData()));

                        isHeightEvent = false;
                    }
                break;

                case XMLStreamConstants.END_ELEMENT:
                    if (event.asEndElement().getName().getLocalPart().equalsIgnoreCase("rectangle")){
                        if(rectangle.getLength() > 20){
                            rectangles.add(rectangle);
                        }
                    }
                break;
            }
        }

        return rectangles;
    }

    public static void serializeCirclesStax(List<Circle> circles, String path) throws Exception{
        XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(path + "/Circles_Stax.xml"));

        xmlWriter.writeStartDocument();
        xmlWriter.writeStartElement("Circles");

        for(var circle : circles) {
            xmlWriter.writeStartElement("Circle");

            xmlWriter.writeAttribute("radius", String.valueOf(circle.getRadius()));

            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();

        xmlWriter.flush();
        xmlWriter.close();
    }
}