package homework.jobs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import homework.polygon.Circle;
import homework.util.JsonUtil;

public class CircleJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Logger logger = LogManager.getLogger();
        
        logger.info("Executing circle job");

        Path circlesJsonPath = Path.of("src/main/resources/circles.json");

        try{
            if(!Files.exists(circlesJsonPath)){
                Files.createFile(circlesJsonPath);
            }
            
            List<Circle> circles = JsonUtil.jsonToList(circlesJsonPath, Circle.class);
    
            circles.add(new Circle((int)(Math.random() * 29 + 1)));
            
            JsonUtil.listToJsonFile(circles, circlesJsonPath);
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
    
}
