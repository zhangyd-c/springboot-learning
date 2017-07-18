# springboot

#### springboot-schedule  2017-3-10

`@Scheduled` 参数可以接受两种定时的设置，一种是我们常用的`cron="*/1 * * * * ?"`,一种是 `fixedRate = 1000`，两种都表示每隔一秒打印一下内容。

####fixedRate 说明

`@Scheduled(fixedRate = 1000)` ：上一次开始执行时间点之后1秒再执行（固定每1秒执行一次）</br>
`@Scheduled(fixedDelay = 1000)` ：上一次执行完毕后间隔1秒再执行</br>
`@Scheduled(initialDelay=1000, fixedRate=2000)` ：第一次延迟1秒后执行，之后按fixedRate的规则每2秒执行一次</br>

##### 项目中定时使用到cron表达式，详细使用方法，请参考[SpringTask中cron表达式整理记录](http://www.flyat.cc/article/120cd0ed892042e99f0d185ec12af968)

# 增加动态修改cron的功能

##### 本地只做测试，cron都是写死在程序中的，可以根据业务进行扩展，包括将cron持久化到DB中

```java
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
}
```
 
##### 修改日期：2017-07-18 16:52

##### 注意：为了演示动态修改定时任务的cron，我将原AppSchedulingConfig定时类中的注解释掉了，如果需要可以直接放开注解