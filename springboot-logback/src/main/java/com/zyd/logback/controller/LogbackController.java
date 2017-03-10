package com.zyd.logback.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogbackController.class);

	@Value("${name}")
	private String projectName;

	@Value("${logging.level.com.blog}")
	private String logLevel;

	@RequestMapping("")
	public String index() {
		
		LOGGER.info("{} -- This is a test with logback.The level is {}, Current time {}.", projectName, logLevel,
				new Date());
		
		LOGGER.debug("This level is DEBUG.");
		
		LOGGER.error("This level is ERROR.");
		
		LOGGER.trace("This level is TRACE.");
		
		LOGGER.warn("This level is WARN.");

		LOGGER.info("isInfoEnabled:" + LOGGER.isInfoEnabled());
		return "logback.";
	}
}
