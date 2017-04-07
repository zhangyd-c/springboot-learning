package com.zyd.servlet.config.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class WebAppListener implements ServletContextListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebAppListener.class); 
	
	public static ServletContext context;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("WebAppListener监听器已销毁...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("WebAppListener监听器开始初始化...");
		context = arg0.getServletContext();
		LOGGER.info("WebAppListener监听器初始化完成...");
	}

}
