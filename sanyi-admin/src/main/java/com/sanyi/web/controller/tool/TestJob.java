package com.sanyi.web.controller.tool;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author songJie.he
 * @Date 2020/11/11 16:00
 * @Version 1.0
 */
public class TestJob implements Job {

    private static Integer i = 0;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务：" + i);
    }
}
