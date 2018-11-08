package me.zhyd.springboot.schedule.task;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 动态定时任务
 * Created by yadong.zhang on me.zhyd.springboot.schedule.task
 *
 * @Author: yadong.zhang
 * @Date: 2017/7/18 15:53
 */
@Component
public class DynamicScheduledConfigurer implements SchedulingConfigurer {

    // 默认每秒执行一次定时任务
    private String cron = "0/1 * * * * ?";
    private AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            int index = integer.incrementAndGet();
            System.out.println(String.format("[%s] %s 动态定时任务 start @ %s", index, Thread.currentThread(), LocalTime.now()));
        }, triggerContext -> {
            CronTrigger trigger = new CronTrigger(this.getCron());
            return trigger.nextExecutionTime(triggerContext);
        });
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        System.out.println(String.format("%s Cron已修改！修改前：%s，修改后：%s @ %s", Thread.currentThread(), this.cron, cron, LocalTime.now()));
        this.cron = cron;
    }
}
