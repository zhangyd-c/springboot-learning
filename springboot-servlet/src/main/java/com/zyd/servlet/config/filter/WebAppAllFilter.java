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

@WebFilter(filterName = "WebAppAllFilter", urlPatterns = { "/servlet/*" })
/*
 * 定义执行的优先级，数字越低，优先级越高
 */
@Order(1)
public class WebAppAllFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebAppAllFilter.class);

	@Override
	public void destroy() {
		LOGGER.info("WebAppAllFilter - 过滤器已销毁...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		
        LOGGER.info("WebAppAllFilter - Request URL: {}", request.getRequestURL().toString());
        LOGGER.info("WebAppAllFilter - Request port：{}", request.getServerPort());
        LOGGER.info("WebAppAllFilter - Request Method: {}", request.getMethod());
        
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setHeader("Current-Path", request.getServletPath());
		response.setHeader("My-Name", "MeiNanzi");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("WebAppAllFilter - {}初始化过滤器...", new Date());
	}

}
