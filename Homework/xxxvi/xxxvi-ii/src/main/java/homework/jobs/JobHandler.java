package homework.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;

import homework.util.Pair;

public class JobHandler {
    public static Pair<JobDetail, SimpleTrigger> setupCircleJob(){
        JobDetail circleJob = JobBuilder.newJob(CircleJob.class)
            .withIdentity("circle_job", "polygon_jobs")
        .build();

        SimpleTrigger circleJobTrigger = TriggerBuilder.newTrigger()
            .withIdentity("circle_trigger")
            .startNow()
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5)
                    .withRepeatCount(3)
            )
        .build();

        return new Pair<>(circleJob, circleJobTrigger);
    }

    public static Pair<JobDetail, SimpleTrigger> setupRectangleJob(){
        JobDetail rectangleJob = JobBuilder.newJob(RectangleJob.class)
            .withIdentity("rectangle_job", "polygon_jobs")
        .build();

        SimpleTrigger rectangleJobTrigger = TriggerBuilder.newTrigger()
            .withIdentity("rectangle_trigger")
            .startNow()
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(6)
                    .withRepeatCount(2)
            )
        .build();

        return new Pair<>(rectangleJob, rectangleJobTrigger);
    }

    public static Pair<JobDetail, SimpleTrigger> setupTriangleJob(){
        JobDetail triangleJob = JobBuilder.newJob(TriangleJob.class)
            .withIdentity("triangle_job", "polygon_jobs")
        .build();

        SimpleTrigger triangleJobTrigger = TriggerBuilder.newTrigger()
            .withIdentity("triangle_trigger")
            .startNow()
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(7)
                    .withRepeatCount(4)
            )
        .build();

        return new Pair<>(triangleJob, triangleJobTrigger);
    }
}
