package me.zhyd.springboot.schedule.task;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 普通定时任务
 */
@Component
public class AppSchedulingConfigurer implements ApplicationListener<ContextRefreshedEvent> {

    private AtomicInteger integer = new AtomicInteger(0);

    /**
     * 在11月7号晚上22点的7分到8分之间每隔半分钟（30秒）执行一次任务
     *
     * @author zhangyd
     */
    @Scheduled(cron = "0/30 7-8 22 7 11 ? ")
    public void doJobByCron() throws InterruptedException {
        int index = integer.incrementAndGet();
        System.out.println(String.format("[%s] %s doJobByCron start @ %s", index, Thread.currentThread(), LocalTime.now()));
        // 这儿随机睡几秒，方便查看执行效果
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        System.out.println(String.format("[%s] %s doJobByCron end   @ %s", index, Thread.currentThread(), LocalTime.now()));
    }

    /**
     * 上次任务执行完的3秒后再次执行
     *
     * @author zhangyd
     */
    @Scheduled(fixedDelay = 3000)
    public void doJobByFixedDelay() throws InterruptedException {
        int index = integer.incrementAndGet();
        System.out.println(String.format("[%s] %s doJobByFixedDelay start @ %s", index, Thread.currentThread(), LocalTime.now()));
        // 这儿随机睡几秒，方便查看执行效果
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        System.out.println(String.format("[%s] %s doJobByFixedDelay end   @ %s", index, Thread.currentThread(), LocalTime.now()));
    }

    /**
     * 固定每3秒执行一次
     *
     * @author zhangyd
     */
    @Scheduled(fixedRate = 3000)
    public void doJobByFixedRate() throws InterruptedException {
        int index = integer.incrementAndGet();
        System.out.println(String.format("[%s] %s doJobByFixedRate start @ %s", index, Thread.currentThread(), LocalTime.now()));
        // 这儿随机睡几秒，方便查看执行效果
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        System.out.println(String.format("[%s] %s doJobByFixedRate end   @ %s", index, Thread.currentThread(), LocalTime.now()));
    }

    /**
     * 第一次延迟5秒后执行，之后按fixedRate的规则每3秒执行一次
     *
     * @author zhangyd
     */
    @Scheduled(initialDelay = 5000, fixedRate = 3000)
    public void doJobByInitialDelay() throws InterruptedException {
        int index = integer.incrementAndGet();
        System.out.println(String.format("[%s] %s doJobByInitialDelay start @ %s", index, Thread.currentThread(), LocalTime.now()));
        // 这儿随机睡几秒，方便查看执行效果
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        System.out.println(String.format("[%s] %s doJobByInitialDelay end   @ %s", index, Thread.currentThread(), LocalTime.now()));
    }

    /**
     * 监听程序启动-Spring容器初始化完成
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationReadyEvent) {
        System.out.println(String.format("springboot上下文context准备完毕时. %s start @ %s", Thread.currentThread(), LocalTime.now()));
    }

}
