package me.zhyd.springboot.servlet.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppListener2 implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppListener2.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        LOGGER.info("WebAppListener2通过SpringBean实现的监听器已销毁...");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        LOGGER.info("WebAppListener2通过SpringBean实现的监听器开始初始化...");
    }

}
