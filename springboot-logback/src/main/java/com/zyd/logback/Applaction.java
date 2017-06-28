package com.zyd.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 官方文档
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html
 */
@SpringBootApplication
@RestController
public class Applaction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Applaction.class);

    /**
     * 获取配置文件中的属性值
     */
    @Value("${app.name}")
    private String projectName;

    @RequestMapping("/")
    public String index() {
        /*
            logback.xml中指定的默认输出级别为INFO，所以低于INFO级别(DEBUG、TRACE)的日志不会输出
            级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
         */
        LOGGER.info("{} -- This is a test with logback., Current time {}.", projectName, new Date());
        LOGGER.trace("This level is TRACE.");
        LOGGER.debug("This level is DEBUG.");
        LOGGER.debug("This level is DEBUG.", LOGGER.isDebugEnabled());
        LOGGER.info("This level is INFO.");
        LOGGER.info("isInfoEnabled:" + LOGGER.isInfoEnabled());
        LOGGER.warn("This level is WARN.");
        LOGGER.error("This level is ERROR.");
        return "logback.";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Applaction.class, args);
    }
}
