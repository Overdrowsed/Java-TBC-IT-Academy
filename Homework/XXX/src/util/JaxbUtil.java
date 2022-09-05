package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import jaxb.Triangles;

public class JaxbUtil {
    public static <Generic> void serialize(Generic object, String path) throws Exception{
        FileOutputStream output = new FileOutputStream(path);

        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(object, output);
    }

    public static void modifyTriangles(String inputPath, String outputPath, String schemaPath) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Triangles triangles = (Triangles) context.createUnmarshaller().unmarshal(new File(inputPath));

        List<Triangles.Triangle> trianglesList = triangles.getTriangles();

        trianglesList.remove(0);

        Triangles.Triangle triangle = trianglesList.get(3);
        
        triangle.setA(6);
        triangle.setB(6);
        triangle.setC(3);
        
        Triangles.Triangle newTriangle = new Triangles.Triangle();

        newTriangle.setA(6);
        newTriangle.setB(7);
        newTriangle.setC(8);

        trianglesList.add(newTriangle);

        serialize(triangles, outputPath);

        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(new File(schemaPath));
                result.setSystemId(schemaPath);
                return result;
            }
        });
    }
}
