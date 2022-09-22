package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import polygon.Rectangle;
import jaxb.Rectangles;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.UnmarshalException;

public class XmlUtil {    
    public static void rectanglesToXml(List<Rectangle> rectangleList, String path) throws JAXBException, FileNotFoundException{
        Rectangles rectangles = new Rectangles(rectangleList);
        
        FileOutputStream output = new FileOutputStream(path);

        JAXBContext context = JAXBContext.newInstance(Rectangles.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(rectangles, output);
    }

    public static List<Rectangle> xmlToRectangles(String path) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Rectangles.class);

        Rectangles rectangles = (Rectangles) context.createUnmarshaller().unmarshal(new File(path));

        return rectangles.getRectangles();
    }

    public static Rectangle streamToRectangle(InputStream input) throws UnmarshalException, JAXBException{
        JAXBContext context = JAXBContext.newInstance(Rectangle.class);

        Rectangle rectangle = (Rectangle) context.createUnmarshaller().unmarshal(input);

        return rectangle;
    }

    public static void updateRectangleDatabase(String rectangleDatabasePath, Rectangle newRectangle) throws JAXBException, FileNotFoundException, IllegalArgumentException{
        if(newRectangle == null || !newRectangle.validate()){
            throw new IllegalArgumentException("Invalid rectangle");
        }
        
        List<Rectangle> rectangles = xmlToRectangles(rectangleDatabasePath);

        rectangles.add(newRectangle);

        rectanglesToXml(rectangles, rectangleDatabasePath);
    }

    public static void sendXmlResponse(List<Rectangle> rectanglesList, HttpServletResponse response) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(Rectangles.class);

        Rectangles rectangles = new Rectangles(rectanglesList);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(rectangles, response.getOutputStream());
    }
}
