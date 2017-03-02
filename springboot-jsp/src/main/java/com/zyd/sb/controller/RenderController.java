package com.zyd.sb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RenderController {
	
	@Value("${application.test}")  
    private String message = "Hi moocer, are you OK?";  
  
    @RequestMapping("/")  
    public String index(Map<String, Object> model) {  
        model.put("message", this.message);  
        return "test";  
    } 
}
