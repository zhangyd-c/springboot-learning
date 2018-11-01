package me.zhyd.springboot.property.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月1日 下午4:34:18 
 * @version V1.0
 * @since JDK ： 1.7
 */
@Configuration
@PropertySource("classpath:/conf/app-config.properties")
@ConfigurationProperties(prefix = "com.zyd2")
public class PropertiesConfigTwo {

	public String type;
	public String title;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
