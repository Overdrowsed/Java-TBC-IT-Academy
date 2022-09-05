package main;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import generator.FigureGenerator;
import util.JaxbUtil;

public class App {
    public static void main(String[] args) throws Exception {
        Logger logger = LogManager.getLogger();

        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "main");

        try{
            String path = "out/xml/circles_output.xml";

            logger.info("starting circle serialization to {}", path);

            JaxbUtil.serialize(FigureGenerator.generateCircles(), path);

            
            logger.info("successfully serialized circles to {}", path);
        }
        catch(Exception exception){
            logger.error(exception);
        }

        try{
            String path = "out/xml/rectangles_output.xml";

            logger.info("starting rectangle serialization to {}", path);

            JaxbUtil.serialize(FigureGenerator.generateRectangles(), path);

            logger.info("successfully serialized rectangles to {}", path);
        }
        catch(Exception exception){
            logger.error(exception);
        }

        try{
            String inputPath = "data/triangles_input.xml";
            String outputPath = "out/xml/triangles_input.xml";
            String schemaPath = "data/triangles.xsd";
                   
            logger.info("starting triangle xml modification from {}", inputPath);

            JaxbUtil.modifyTriangles(inputPath, outputPath, schemaPath);

            logger.info(
                "successfully modified triangles from {}, saved to {} and generated schema at {}",
                inputPath, outputPath, schemaPath
            );
        } catch(Exception exception){
            logger.error(exception);
        }
    }
}
