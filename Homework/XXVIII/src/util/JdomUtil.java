package util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;


public class JdomUtil {
    public static List<Triangle> deserializeTrianglesJdom(String path) throws Exception{
        Document document = new SAXBuilder().build(new File(path));

        Element trianglesElement = document.getRootElement();

        List<Element> triangleElements = trianglesElement.getChildren();
        
        List<Triangle> triangles = new ArrayList<>();

        for(var triangleElement : triangleElements){
            List<Integer> sides = new ArrayList<>();

            for(var side : triangleElement.getChildren()){
                sides.add(Integer.valueOf(side.getText()));
            }

            Triangle triangle = new Triangle(
                sides.get(0),
                sides.get(1),
                sides.get(2)
            );

            if(triangle.getLength() > 20)
                triangles.add(triangle);
        }

        return triangles;
    }

    public static void serializeRectanglesJdom(List<Rectangle> rectangles, String path) throws Exception{
        Document document = new Document(new Element("Rectangles"));

        for(var rectangle : rectangles){
            Element rectangleElement = new Element("Rectangle");
            
            Element widthElement = new Element("width");
            Element heightElement= new Element("height");

            widthElement.setText(String.valueOf(rectangle.getWidth()));
            heightElement.setText(String.valueOf(rectangle.getHeight()));

            rectangleElement.addContent(widthElement);
            rectangleElement.addContent(heightElement);

            document.getRootElement().addContent(rectangleElement);
        }

        XMLOutputter output = new XMLOutputter();

        output.setFormat(Format.getPrettyFormat());

        output.output(document, new FileOutputStream(path));
    }

    public static void serializeCirclesJdom(List<Circle> circles, String path) throws Exception{
        Document document = new Document(new Element("Circles"));

        for(var circle : circles){
            Element circleElement = new Element("Circle");
            
            Element radiusElement = new Element("radius");

            radiusElement.setText(String.valueOf(circle.getRadius()));

            circleElement.addContent(radiusElement);

            document.getRootElement().addContent(circleElement);
        }

        XMLOutputter output = new XMLOutputter();

        output.setFormat(Format.getPrettyFormat());

        output.output(document, new FileOutputStream(path + "Circles_Jdom.xml"));
    }
}
