package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.UnmarshalException;
import jaxb.Triangles;
import polygon.Triangle;

public class XmlUtil {
    public static void trianglesToXml(List<Triangle> triangleList, String path) throws JAXBException, FileNotFoundException{
        Triangles triangles = new Triangles(triangleList);
        
        FileOutputStream output = new FileOutputStream(path);

        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(triangles, output);
    }

    public static List<Triangle> xmlToTriangles(String path) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Triangles triangles = (Triangles) context.createUnmarshaller().unmarshal(new File(path));

        return triangles.getTriangles();
    }

    public static Triangle streamToTriangle(InputStream input) throws UnmarshalException, JAXBException{
        JAXBContext context = JAXBContext.newInstance(Triangle.class);

        Triangle triangle = (Triangle) context.createUnmarshaller().unmarshal(input);

        return triangle;
    }

    public static void updateTriangleDatabase(String triangleDatabasePath, Triangle newTriangle) throws JAXBException, FileNotFoundException, IllegalArgumentException{
        if(newTriangle == null || !newTriangle.validate()){
            throw new IllegalArgumentException("Invalid triangle");
        }
        
        List<Triangle> triangles = xmlToTriangles(triangleDatabasePath);

        triangles.add(newTriangle);

        trianglesToXml(triangles, triangleDatabasePath);
    }

    public static void sendXmlResponse(List<Triangle> trianglesList, HttpServletResponse response) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Triangles triangles = new Triangles(trianglesList);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(triangles, response.getOutputStream());
    }
}
