package com.zyd.property;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.property.config.PropertiesConfig;
import com.zyd.property.config.PropertiesListenerConfig;
import com.zyd.property.listener.PropertiesListener;

/**
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月1日 下午3:49:30 
 * @version V1.0
 * @since JDK ： 1.7
 */
@SpringBootApplication
@RestController
public class Applaction {
	
	@Autowired
	private PropertiesConfig propertiesConfig;

	/**
	 * 
	 * 第一种方式：使用`@ConfigurationProperties`注解将配置文件属性注入到配置对象类中
	 * 
	 * @author zyd
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.7
	 */
	@RequestMapping("/config")
	public Map<String, Object> configurationProperties() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", propertiesConfig.getType3());
		map.put("title", propertiesConfig.getTitle3());
		map.put("login", propertiesConfig.getLogin());
		map.put("urls", propertiesConfig.getUrls());
		return map;
	}

	@Value("${com.zyd.type}")
	private String type;

	@Value("${com.zyd.title}")
	private String title;

	/**
	 * 
	 * 第二种方式：使用`@Value("${propertyName}")`注解
	 * 
	 * @author zyd
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.7
	 */
	@RequestMapping("/value")
	public Map<String, Object> value() throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		// *.properties文件中的中文默认以ISO-8859-1方式编码，因此需要对中文内容进行重新编码
		map.put("title", new String(title.getBytes("ISO-8859-1"), "UTF-8"));
		return map;
	}

	@Autowired
	private Environment env;

	/**
	 * 
	 * 第三种方式：使用`Environment`
	 * 
	 * @author zyd
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.7
	 */
	@RequestMapping("/env")
	public Map<String, Object> env() throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", env.getProperty("com.zyd.type2"));
		map.put("title", new String(env.getProperty("com.zyd.title2").getBytes("ISO-8859-1"), "UTF-8"));
		return map;
	}

	/**
	 * 
	 * 第四种方式：通过注册监听器(`Listeners`) + `PropertiesLoaderUtils`的方式
	 * 
	 * @author zyd
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.7
	 */
	@RequestMapping("/listener")
	public Map<String, Object> listener() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(PropertiesListenerConfig.getAllProperty());
		return map;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Applaction.class);
		// 第四种方式：注册监听器
		application.addListeners(new PropertiesListener("app-config.properties"));
		application.run(args);
	}
}
