package me.zhyd.springboot.errorpage.conf;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Description 自定义异常页面配置类
 * @author zhangyd
 * @date 2017年3月15日 下午3:13:43 
 * @version V1.0
 * @since JDK ： 1.7
 * @modify                 
 * @Review
 */
@Component
public class AppErrorPagesConfiguration {
	
	/**
	 * 自定义异常处理路径
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(java.lang.Throwable.class, "/error/500"));
			}
		};
	}
}
