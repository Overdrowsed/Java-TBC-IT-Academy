package homework.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import homework.jobs.CircleJob;
import homework.jobs.JobHandler;
import homework.polygon.Circle;
import homework.polygon.Rectangle;
import homework.polygon.Triangle;
import homework.util.JsonUtil;
import homework.util.Pair;

@SuppressWarnings("unused")
public class App{
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

        logger.info("Starting job execution");
        
        try{
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            
            var circleJob = JobHandler.setupCircleJob();
            var rectangleJob = JobHandler.setupRectangleJob();
            var triangleJob = JobHandler.setupTriangleJob();
            
            scheduler.scheduleJob(circleJob.first, circleJob.second);
            scheduler.scheduleJob(rectangleJob.first, rectangleJob.second);
            scheduler.scheduleJob(triangleJob.first, triangleJob.second);
            
            scheduler.start();
    
            Thread.sleep(36000);
    
            scheduler.shutdown(true);
    
            logger.info("Job execution finished");
        }
        catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }
    }
}
