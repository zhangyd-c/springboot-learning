package com.zyd.servlet.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤index请求
 * @author zhangyd
 * @date 2017年4月7日 下午4:37:28 
 * @version V1.0
 * @since JDK ： 1.7
 * @modify                 
 * @Review
 */
//@WebFilter(filterName = "WebAppForIndexFilter", urlPatterns = { "/servlet/index" })
@Order(-5)
public class WebAppForIndexFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebAppForIndexFilter.class);
	@Override
	public void destroy() {
		LOGGER.info("WebAppForIndexFilter - SpringBean注册的过滤器已销毁...");
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		
        LOGGER.info("WebAppForIndexFilter - Request URL: {}", request.getRequestURL().toString());
        LOGGER.info("WebAppForIndexFilter - Request port：{}", request.getServerPort());
        LOGGER.info("WebAppForIndexFilter - Request Method: {}", request.getMethod());
        
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setHeader("Current-Path", request.getServletPath());
		response.setHeader("My-Name", "MeiNanzi");
		arg2.doFilter(arg0, arg1);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("WebAppForIndexFilter - {}初始化SpringBean注册的过滤器...", new Date());
	}
}
