package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import figure.Circle;
import figure.Figure;
import figure.Rectangle;
import figure.Triangle;
import util.XMLUtility;

public class FigureReader {

    public static void getCirclesToXML(){
        String path = "lib/Circles_in.dat";
        
        try (Scanner circleReader = new Scanner(new File(path))){
            while(circleReader.hasNextLine()){
                int radius = 0;
                
                try{
                    radius = Integer.valueOf(circleReader.nextLine());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }
                
                Circle circle = new Circle(radius);

                if(circle.validate()){
                    try{
                        XMLUtility.serializeXML(circle, "out/circles/");
                    }
                    catch(Exception exception){
                        System.out.println(exception);
                    }
                }
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }
    
    public static void getRectanglesToXML(){
        String path = "lib/Rectangles_in.dat";

        try (Scanner rectangleReader = new Scanner(new File(path))){
            while(rectangleReader.hasNextLine()){
                Scanner sides = new Scanner(rectangleReader.nextLine()).useDelimiter("-");
                
                int width = 0, height = 0;
                
                try{
                    width = Integer.valueOf(sides.next());
                    height = Integer.valueOf(sides.next());
                    
                    if(sides.hasNext())
                    throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Rectangle rectangle = new Rectangle(width, height);
                
                if(rectangle.validate()){
                    try{
                        XMLUtility.serializeXML(rectangle, "out/rectangles/");
                    }
                    catch(Exception exception){
                        System.out.println(exception);
                    }
                }
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void getTrianglesToXML(){
        String path = "lib/Triangles_in.dat";

        try (Scanner triangleReader = new Scanner(new File(path))){
            while(triangleReader.hasNextLine()){
                Scanner sides = new Scanner(triangleReader.nextLine()).useDelimiter("-");

                int sideA = 0, sideB = 0, sideC = 0;

                try{
                    sideA = Integer.valueOf(sides.next());
                    sideB = Integer.valueOf(sides.next());
                    sideC = Integer.valueOf(sides.next());

                    if(sides.hasNext())
                        throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Triangle triangle = new Triangle(sideA, sideB, sideC);

                if(triangle.validate()){
                    try{
                        XMLUtility.serializeXML(triangle, "out/triangles/");
                    }
                    catch(Exception exception){
                        System.out.println(exception);
                    }
                }
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void printFiguresFromXMLDOM(String path) throws Exception{
        File dir = new File(path);

        for(var file : dir.listFiles()){
            if(file.isDirectory()){
                printFiguresFromXMLDOM(file.getPath());
            }
            else{
                Figure figure = XMLUtility.deserializeXMLDOM(file.getPath());
                System.out.println(figure);
            }
        }
    }

    public static void printFiguresFromXMLSAX(String path) throws Exception{
        File dir = new File(path);

        for(var file : dir.listFiles()){
            if(file.isDirectory()){
                printFiguresFromXMLSAX(file.getPath());
            }
            else{
                Figure figure = XMLUtility.deserializeXMLSAX(file.getPath());
                System.out.println(figure);
            }
        }
    }

    public static void compileEditXMLDOM(String path) throws Exception{
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        File dir = new File(path);

        String genericClassCollectionName = dir.listFiles()[0].getName();
        genericClassCollectionName = genericClassCollectionName.substring(0, genericClassCollectionName.indexOf("_")) + "s";
        
        Element root = dom.createElement(genericClassCollectionName);

        dom.appendChild(root);

        for(var file : dir.listFiles()){
            Element element = (Element)XMLUtility.toXMLElement(file.getPath()).cloneNode(true);
            dom.adoptNode(element);

            root.appendChild(element);
        }

        root.removeChild(root.getFirstChild());
        root.removeChild(root.getLastChild());

        for(int i = 0; i < 3; i++){
            Element newRectanglElement = (Element)XMLUtility.toXMLElement(new Rectangle((int)(Math.random() * 99 + 1), (int)(Math.random() * 99 + 1))).cloneNode(true);
            dom.adoptNode(newRectanglElement);
            root.appendChild(newRectanglElement);
        }

        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


        transformer.transform(new DOMSource(dom), new StreamResult(System.out));
    }
}