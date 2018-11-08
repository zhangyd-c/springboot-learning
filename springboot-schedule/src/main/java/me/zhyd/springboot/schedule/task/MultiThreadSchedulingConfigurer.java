package me.zhyd.springboot.schedule.task;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程并行任务
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/8 15:55
 * @since 1.8
 */
@Component
public class MultiThreadSchedulingConfigurer implements SchedulingConfigurer {

    private AtomicInteger integer = new AtomicInteger(0);

    @Scheduled(cron = "0/1 * * * * ?")
    public void multiThread() {
        System.out.println(String.format("[1] %s exec @ %s", Thread.currentThread().getName(), LocalTime.now()));
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void multiThread2() {
        System.out.println(String.format("[2] %s exec @ %s", Thread.currentThread().getName(), LocalTime.now()));
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void multiThread3() {
        System.out.println(String.format("[3] %s exec @ %s", Thread.currentThread().getName(), LocalTime.now()));
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(newExecutors());
    }

    @Bean(destroyMethod = "shutdown")
    private Executor newExecutors() {
        return Executors.newScheduledThreadPool(10, r -> new Thread(r, String.format("ZHYD-MultiThread-Task-%s", integer.incrementAndGet())));
    }
}
