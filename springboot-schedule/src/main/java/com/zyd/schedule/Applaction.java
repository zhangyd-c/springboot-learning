package com.zyd.schedule;

import com.zyd.schedule.task.DynamicScheduledConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Applaction {

	@Autowired
	DynamicScheduledConfig dynamicScheduledConfig;

	// 修改动态定时任务的cron值
	@RequestMapping("/updateTask")
	public Object updateTask() {
		dynamicScheduledConfig.setCron("0/2 * * * * ?");
		return "success";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Applaction.class, args);
	}
}

