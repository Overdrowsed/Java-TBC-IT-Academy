package homework.jobs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import homework.polygon.Rectangle;
import homework.util.JsonUtil;

public class RectangleJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Logger logger = LogManager.getLogger();
        
        logger.info("Executing rectangle job");
        
        Path rectanglesJsonPath = Path.of("src/main/resources/rectangles.json");

        try{
            if(!Files.exists(rectanglesJsonPath)){
                Files.createFile(rectanglesJsonPath);
            }
            
            List<Rectangle> rectangles = JsonUtil.jsonToList(rectanglesJsonPath, Rectangle.class);
    
            rectangles.add(new Rectangle(
                (int)(Math.random() * 29 + 1),
                (int)(Math.random() * 29 + 1)
            ));
            
            JsonUtil.listToJsonFile(rectangles, rectanglesJsonPath);
        }
        catch(Exception exception){
            System.out.println(exception);
        }        
    }
    
}
