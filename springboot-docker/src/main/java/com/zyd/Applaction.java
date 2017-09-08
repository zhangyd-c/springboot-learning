package com.zyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Applaction {
	@GetMapping("/")
	public String index() {
		return "测试Springboot集合docker";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Applaction.class, args);
	}
}
