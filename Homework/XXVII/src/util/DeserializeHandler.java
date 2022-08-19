package util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DeserializeHandler extends DefaultHandler{
    Object returnObject;
    Class<?> returnObjectClass;
    StringBuilder xmlElementText;
    
    @SuppressWarnings("unchecked")
    public <Generic> Generic parse(String path) throws ParserConfigurationException, SAXException, IOException{
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        parser.parse(new File(path), this);

        return (Generic)returnObject;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        xmlElementText = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        xmlElementText.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, qName, qName);
        if(qName.equals("className")){
            try {
                returnObjectClass = Class.forName(xmlElementText.toString());

                Constructor<?> constructor = returnObjectClass.getConstructor();
                returnObject = constructor.newInstance();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            if(!qName.isEmpty() && !qName.isBlank() && !qName.equals(returnObjectClass.getSimpleName())){
                try {
                    Field field = returnObjectClass.getDeclaredField(qName);
                    field.setAccessible(true);
        
                    field.set(returnObject, Integer.valueOf(xmlElementText.toString()));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        xmlElementText.append(ch, start, length);
    }
}
