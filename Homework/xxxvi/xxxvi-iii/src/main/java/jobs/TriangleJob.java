package jobs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import polygon.Triangle;
import util.XmlUtil;

public class TriangleJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Logger logger = LogManager.getLogger("triangle_job");
        
        logger.info("Executing triangle job");
        
        String trianglesXmlPath = "D:/Programs/Tomcat/data/triangles.xml";

        try{
            if(!Files.exists(Path.of(trianglesXmlPath))){
                Files.createFile(Path.of(trianglesXmlPath));
                XmlUtil.trianglesToXml(new ArrayList<Triangle>(), trianglesXmlPath);
            }
            
            List<Triangle> triangles = XmlUtil.xmlToTriangles(trianglesXmlPath);
    
            int operationRepeatAmount = context.getJobDetail().getJobDataMap().getInt("X");

            for(int i = 0; i < operationRepeatAmount; i++){
                int a = (int)(Math.random() * 29 + 1);
                int b = (int)(Math.random() * 29 + 1);
                int c = (int)(Math.random() * (Math.max(a, b) - Math.min(a, b))) + Math.min(a, b);
        
                triangles.add(new Triangle(a, b, c));
            }
            
            XmlUtil.trianglesToXml(triangles, trianglesXmlPath);  
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}
