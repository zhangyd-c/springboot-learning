package me.zhyd.springboot.exception;

/**
 * 模拟400错误处理异常类
 * 
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月8日 上午9:27:29 
 * @version V1.0
 * @since JDK ： 1.7
 */
public class BadRequestException extends Exception {
	  	
	private static final long serialVersionUID = -6091047030159094706L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message) {
		super(message);
	}

}
