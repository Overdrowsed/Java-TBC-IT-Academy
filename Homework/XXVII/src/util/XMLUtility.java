package util;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtility {
    //ParserConfigurationException, IOException, TransformerException, IllegalArgumentException, IllegalAccessException
    public static <Generic> void serializeXML(Generic generic, String path) throws Exception{
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        String genericClassName = generic.getClass().getSimpleName();
        
        Element root = dom.createElement(genericClassName);
        
        dom.appendChild(root);
        
        Element classInfo = dom.createElement("className");
        classInfo.appendChild(dom.createTextNode(generic.getClass().getName()));
        
        root.appendChild(classInfo);

        List<Field> allFields = new ArrayList<>(){
            {
                for(Class<?> c = generic.getClass(); c != null; c = c.getSuperclass()){
                    addAll(Arrays.asList(c.getDeclaredFields()));
                }
            }
        };

        for(var field : allFields){
            Element fieldElement = dom.createElement(field.getName());

            field.setAccessible(true);

            fieldElement.appendChild(dom.createTextNode(String.valueOf(field.get(generic))));

            root.appendChild(fieldElement);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


        transformer.transform(new DOMSource(dom), new StreamResult(new File(path + genericClassName + "_" + new File(path).listFiles().length + ".xml")));
    }

    //ParserConfigurationException, SAXException, IOException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, IllegalArgumentException, InvocationTargetException
    @SuppressWarnings("unchecked")
    public static <Generic> Generic deserializeXMLDOM(String path) throws Exception{
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        
        dom.getDocumentElement().normalize();
        
        Element root = dom.getDocumentElement();
        
        NodeList list = root.getChildNodes();
        
        String className = "";
        int propertyBeginIndex = 0;
        
        for(int i = 0; i < list.getLength(); i++){
            Node currentNode = list.item(i);

            if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                Element currentElement = (Element) currentNode;
                className = currentElement.getTextContent();
                propertyBeginIndex = i + 1;
                break;
            }
        }

        Class<?> returnClass = Class.forName(className);

        Constructor<?> constructor = returnClass.getConstructor();
        Object returnObject = constructor.newInstance();

        List<Field> allFields = new ArrayList<>(){
            {
                for(Class<?> c = returnClass; c != null; c = c.getSuperclass()){
                    addAll(Arrays.asList(c.getDeclaredFields()));
                }
            }
        };

        for(var field : allFields){
            field.setAccessible(true);

            for(int i = propertyBeginIndex; i < list.getLength(); i++){
                Node currentNode = list.item(i);
                
                if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                    Element currentElement = (Element) currentNode;
                    
                    field.set(returnObject, Integer.valueOf(currentElement.getTextContent()));

                    propertyBeginIndex = i + 1;
                    break;
                }
            }
        }

        return (Generic)returnObject;
    }

    public static <Generic> Generic deserializeXMLSAX(String path) throws Exception{
        DeserializeHandler handler = new DeserializeHandler();

        return handler.parse(path);
    }

    public static  Element toXMLElement(String path) throws Exception{
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        
        dom.getDocumentElement().normalize();
        
        Element root = dom.getDocumentElement();

        return root;
    }

    public static <Generic> Element toXMLElement(Generic generic) throws Exception{
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        String genericClassName = generic.getClass().getSimpleName();
        
        Element root = dom.createElement(genericClassName);
        
        dom.appendChild(root);
        
        Element classInfo = dom.createElement("className");
        classInfo.appendChild(dom.createTextNode(generic.getClass().getName()));
        
        root.appendChild(classInfo);

        List<Field> allFields = new ArrayList<>(){
            {
                for(Class<?> c = generic.getClass(); c != null; c = c.getSuperclass()){
                    addAll(Arrays.asList(c.getDeclaredFields()));
                }
            }
        };

        for(var field : allFields){
            Element fieldElement = dom.createElement(field.getName());

            field.setAccessible(true);

            fieldElement.appendChild(dom.createTextNode(String.valueOf(field.get(generic))));

            root.appendChild(fieldElement);
        }

        return root;
    }
}
