package homework.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class App {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

        logger.info("Starting job execution");
        
        try{
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
        }
        catch(SchedulerException exception){
            logger.error(exception.getMessage(), exception);
        }
    }
}
