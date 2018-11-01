/**
 * Copyright [2016-2017] [yadong.zhang]
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.zhyd.springboot.schedule.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 动态定时任务
 * Created by yadong.zhang on com.zyd.schedule.task
 *
 * @Author: yadong.zhang
 * @Date: 2017/7/18 15:53
 */
@Component
@EnableScheduling
public class DynamicScheduledConfig implements SchedulingConfigurer {

    // 默认每秒执行一次定时任务
    private String cron = "0/1 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 定时任务一
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务一，当前时间：" + new Date());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });

        // 定时任务二
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务二，当前时间：" + new Date());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });

        // 定时任务三：此种不会因为cron的改变而改变任务执行时间
        taskRegistrar.addCronTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务三，当前时间：" + new Date());
            }
        }, this.getCron());

        // 定时任务四：此种不会因为cron的改变而改变任务执行时间
        taskRegistrar.addCronTask(new CronTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务四，当前时间：" + new Date());
            }
        }, new CronTrigger(this.getCron())));

    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getCron() {
        return cron;
    }
}
