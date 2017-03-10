package com.zyd.schedule.task;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AppScheduleTask {
	
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void task() {
		System.out.println("开启定时任务,每分钟执行一次：" + new Date());
	}
}
