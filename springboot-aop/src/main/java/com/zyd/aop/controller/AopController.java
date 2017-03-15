package com.zyd.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AopController.class);

	@Value("${name}")
	private String projectName;

	@RequestMapping("")
	public String index() {
		LOGGER.info("projectName:{}", projectName);
		return projectName;
	}
}
