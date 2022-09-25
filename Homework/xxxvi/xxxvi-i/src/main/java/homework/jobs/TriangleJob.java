package homework.jobs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import homework.polygon.Triangle;
import homework.util.JsonUtil;

public class TriangleJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Logger logger = LogManager.getLogger();
        
        logger.info("Executing triangle job");
        
        Path trianglesJsonPath = Path.of("src/main/resources/triangles.json");

        try{
            if(!Files.exists(trianglesJsonPath)){
                Files.createFile(trianglesJsonPath);
            }
            
            List<Triangle> triangles = JsonUtil.jsonToList(trianglesJsonPath, Triangle.class);
    
            int a = (int)(Math.random() * 29 + 1);
            int b = (int)(Math.random() * 29 + 1);
            int c = (int)(Math.random() * (Math.max(a, b) - Math.min(a, b))) + Math.min(a, b);
    
            triangles.add(new Triangle(a, b, c));
            
            JsonUtil.listToJsonFile(triangles, trianglesJsonPath);  
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
    
}
