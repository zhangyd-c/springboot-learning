package com.zyd.exception;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.exception.exception.BadRequestException;
import com.zyd.exception.exception.NotFoundException;
import com.zyd.exception.exception.ZhangydException;

@SpringBootApplication
@RestController
public class Applaction {

	@RequestMapping("/{view}")
	public Object index(@PathVariable("view") String view) throws Exception {
		View v = View.getView(view);
		switch (v) {
		case sql:
			throw new SQLException("数据库异常！");
		case bad:
			throw new BadRequestException("失败的请求！");
		case zhyd:
			throw new ZhangydException(50000, "这是一个自定义的异常！");
		case exception:
			return 1 / 0;
		default:
			throw new NotFoundException("页面未找到！");
		}
	}

	/**
	 * 测试代码：有效页面枚举类
	 * 
	 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
	 * @date 2017年6月8日 上午9:22:47
	 * @version V1.0
	 * @since JDK ： 1.7
	 */
	private enum View {
		sql, bad, zhyd, exception, none;

		public static View getView(String view) {
			for (View v : View.values()) {
				if (v.toString().equalsIgnoreCase(view)) {
					return v;
				}
			}
			return none;
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Applaction.class, args);
	}
}
