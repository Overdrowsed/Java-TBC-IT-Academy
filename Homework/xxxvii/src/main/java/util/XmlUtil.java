package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import polygon.Triangle;
import jaxb.Triangles;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtil {    
    public static void trianglesToXml(List<Triangle> triangleList, String path) throws JAXBException, FileNotFoundException{
        Triangles triangles = new Triangles(triangleList);
        
        FileOutputStream output = new FileOutputStream(path);

        JAXBContext context = JAXBContext.newInstance(Triangle[].class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(triangles, output);
    }
    
    public static List<Triangle> xmlToTriangles(URL input) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Triangles triangles = (Triangles) context.createUnmarshaller().unmarshal(input);

        return triangles.getTriangles();
    }

    public static void sendXmlResponse(Triangle triangle, HttpServletResponse response) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(triangle, response.getOutputStream());
    }
}
