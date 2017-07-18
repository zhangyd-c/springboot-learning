package com.zyd.servlet.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        LOGGER.info("WebAppListener通过注解实现的监听器已销毁...");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        LOGGER.info("WebAppListener通过注解实现的监听器开始初始化...");
    }

}
