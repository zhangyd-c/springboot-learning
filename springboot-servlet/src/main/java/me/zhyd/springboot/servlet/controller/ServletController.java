package me.zhyd.springboot.servlet.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 
 * @author zhangyd
 * @date 2017年4月7日 下午4:37:11 
 * @version V1.0
 * @since JDK ： 1.7
 * @modify                 
 * @Review
 */
@RestController
@RequestMapping("/servlet")
public class ServletController {

	@RequestMapping("/index")
	public Object index() {
		return new Date() + " - index";
	}
	
	@RequestMapping("/filter1")
	public Object filter1() {
		return new Date() + " - filter1";
	}
	
	@RequestMapping("/filter2")
	public Object filter2() {
		return new Date() + " - filter2";
	}
}
