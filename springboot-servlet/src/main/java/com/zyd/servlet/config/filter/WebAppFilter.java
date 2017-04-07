package com.zyd.servlet.config.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * @Description 
 * @author zhangyd
 * @date 2017年4月7日 下午4:37:23 
 * @version V1.0
 * @since JDK ： 1.7
 * @modify                 
 * @Review
 */
@WebFilter(filterName = "WebAppFilter", urlPatterns = { "/servlet/filter1","/servlet/filter2" })
/*
 * 定义执行的优先级，数字越低，优先级越高
 */
@Order(0)
public class WebAppFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebAppFilter.class);

	@Override
	public void destroy() {
		LOGGER.info("WebAppFilter - 过滤器已销毁...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		
        LOGGER.info("WebAppFilter - Request URL: {}", request.getRequestURL().toString());
        LOGGER.info("WebAppFilter - Request port：{}", request.getServerPort());
        LOGGER.info("WebAppFilter - Request Method: {}", request.getMethod());
        
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setHeader("Current-Path", request.getServletPath());
		response.setHeader("My-Name", "MeiNanzi");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("WebAppFilter - {}初始化过滤器...", new Date());
	}

}
