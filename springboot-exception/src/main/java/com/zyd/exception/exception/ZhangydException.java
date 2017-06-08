package com.zyd.exception.exception;

/**
 * 自定义的异常类
 * 
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月8日 上午9:27:29
 * @version V1.0
 * @since JDK ： 1.7
 */
public class ZhangydException extends Exception {

	private static final long serialVersionUID = 3720658094018235765L;

	private Integer code;

	public ZhangydException() {
		super();
	}

	public ZhangydException(String message) {
		super(message);
	}

	public ZhangydException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
