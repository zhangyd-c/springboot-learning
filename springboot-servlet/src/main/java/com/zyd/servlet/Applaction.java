package com.zyd.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Applaction {

	/**
	 * @Description 注册webAppFilter
	 * @author zhangyd
	 * @date 2017年4月7日 下午4:37:37
	 * @return
	 */
	// @Bean
	// public FilterRegistrationBean webAppFilterRegistrationBean() {
	// FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	// registrationBean.setName("webAppFilter");
	// WebAppFilter webAppFilter = new WebAppFilter();
	// registrationBean.setFilter(webAppFilter);
	// registrationBean.setOrder(0);
	// List<String> urlList = new ArrayList<String>();
	// urlList.add("/servlet/filter1");
	// urlList.add("/servlet/filter2");
	// registrationBean.setUrlPatterns(urlList);
	// return registrationBean;
	// }

	/**
	 * @Description 注册webAppForIndexFilter
	 * @author zhangyd
	 * @date 2017年4月7日 下午4:37:37
	 * @return
	 */
	// @Bean
	// public FilterRegistrationBean webAppForIndexFilterRegistrationBean() {
	// FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	// registrationBean.setName("webAppForIndexFilter");
	// WebAppForIndexFilter webAppForIndexFilter = new WebAppForIndexFilter();
	// registrationBean.setFilter(webAppForIndexFilter);
	// registrationBean.setOrder(-1);
	// List<String> urlList = new ArrayList<String>();
	// urlList.add("/servlet/index");
	// urlList.add("/servlet/filter2");
	// registrationBean.setUrlPatterns(urlList);
	// return registrationBean;
	// }

	/**
	 * 
	 * @Description 注册WebAppListener
	 * @author zhangyd
	 * @date 2017年4月7日 下午5:18:01 
	 * @param args
	 */
//	@Bean
//	public ServletListenerRegistrationBean<WebAppListener> servletListenerRegistrationBean() {
//		ServletListenerRegistrationBean<WebAppListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<WebAppListener>();
//		servletListenerRegistrationBean.setListener(new WebAppListener());
//		return servletListenerRegistrationBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Applaction.class, args);
	}
}
