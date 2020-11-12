package com.sanyi.web.controller.tool;


import com.sanyi.common.utils.http.HttpUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author songjie.he
 * @Date 2020/11/9 9:38
 * @Version 1.0
 */

public class Test {

    public static void main(String[] args) throws SchedulerException {
        // 创建调度器scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity("job-1", "group-1").build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger-1", "triggerGroup-1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 29 16 10 11 ? *"))
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println("开始");
        scheduler.start();
        System.out.println("结束");
    }
}
