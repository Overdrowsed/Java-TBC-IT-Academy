package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import figure.Circle;

public class XpathUtil {
    public static void filterCirclesAttribute(String path) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        XPathExpression expression = xPath.compile("/Circles/Circle[@radius>30]");

        NodeList nodeList = (NodeList)expression.evaluate(document, XPathConstants.NODESET);

        if(nodeList.getLength() == 0)
            System.out.println("No circles satisfy condition radius > 30");

        for(int i = 0; i < nodeList.getLength(); i++){
            Node currentNode = nodeList.item(i);

            if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                Element currentElement = (Element) currentNode;
                
                Circle circle = new Circle(Integer.valueOf(currentElement.getAttribute("radius")));

                System.out.println(circle);
            }
        }

        expression = xPath.compile("(/Circles/Circle[@radius<40])[last()]");

        Node lastCircle = (Node)expression.evaluate(document, XPathConstants.NODE);

        int radius = 0;

        try{
            radius = Integer.valueOf(((Element)lastCircle).getAttribute("radius"));
        }
        catch(NullPointerException exception){
            System.out.println("No circles satisfy condition radius < 40");
            return;
        }

        Circle circle = new Circle(radius);

        System.out.println("Last circle with radius < 40: " + circle);
    }

    public static void filterCirclesElement(String path) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        XPathExpression expression = xPath.compile("/Circles/Circle[radius<=30]");

        NodeList nodeList = (NodeList)expression.evaluate(document, XPathConstants.NODESET);

        if(nodeList.getLength() == 0)
            System.out.println("No circles satisfy condition radius <= 30");

        for(int i = 0; i < nodeList.getLength(); i++){
            Node currentNode = nodeList.item(i);

            if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                Element currentElement = (Element) currentNode;
                
                Circle circle = new Circle(Integer.valueOf(currentElement.getElementsByTagName("radius").item(0).getTextContent()));

                System.out.println(circle);
            }
        }

        expression = xPath.compile("(/Circles/Circle[radius>=40])[1]");

        Node lastCircle = (Node)expression.evaluate(document, XPathConstants.NODE);

        int radius = 0;

        try{
            radius = Integer.valueOf(((Element)lastCircle).getElementsByTagName("radius").item(0).getTextContent());
        }
        catch(NullPointerException exception){
            System.out.println("No circles satisfy condition radius >= 40");
            return;
        }

        Circle circle = new Circle(radius);

        System.out.println("First circle with radius >= 40: " + circle);
    }
}
