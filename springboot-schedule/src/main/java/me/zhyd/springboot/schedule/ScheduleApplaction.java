package me.zhyd.springboot.schedule;

import com.alibaba.fastjson.JSONArray;
import me.zhyd.springboot.schedule.task.DynamicScheduledConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

@SpringBootApplication
@Controller
@EnableScheduling
public class ScheduleApplaction {

    @Autowired
    DynamicScheduledConfigurer dynamicScheduledConfigurer;

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplaction.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 修改动态定时任务的cron值
     */
    @RequestMapping("/updateTask")
    @ResponseBody
    public void updateTask(String cron) {
        dynamicScheduledConfigurer.setCron(cron);
    }

    /**
     * 预解析5此该cron将要执行的时间节点
     *
     * @param cron 带解析的cron
     * @return
     * @throws IOException
     */
    @RequestMapping("/parseCron")
    @ResponseBody
    public List<String> parseCron(String cron) throws IOException {
        String urlNameString = "http://cron.qqe2.com/CalcRunTime.ashx?CronExpression=" + URLEncoder.encode(cron, "UTF-8");
        URL realUrl = new URL(urlNameString);
        URLConnection connection = realUrl.openConnection();
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        connection.connect();

        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONArray.parseArray(result.toString(), String.class);
    }
}

