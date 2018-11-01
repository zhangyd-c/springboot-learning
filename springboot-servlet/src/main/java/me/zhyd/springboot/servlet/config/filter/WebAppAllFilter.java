package me.zhyd.springboot.servlet.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤所有的请求
 * @author zhangyd
 * @date 2017年4月7日 下午4:37:28
 * @version V1.0
 * @since JDK ： 1.7
 * @modify
 * @Review
 */
@WebFilter(filterName = "WebAppAllFilter", urlPatterns = { "/*" })
@Order(1) // 定义执行的优先级，数字越低，优先级越高
public class WebAppAllFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebAppAllFilter.class);
	@Override
	public void destroy() {
		LOGGER.info("WebAppAllFilter - 注解实现的过滤器已销毁...");
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
		LOGGER.info("WebAppAllFilter - {}初始化注解实现的过滤器...", new Date());
	}
}
