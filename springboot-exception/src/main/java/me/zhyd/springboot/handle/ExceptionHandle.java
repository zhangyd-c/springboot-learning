/**   
 * Copyright © 2017 Innodev. All rights reserved.
 * 
 * @Title ExceptionHandle.java 
 * @Package com.zyd.exception.handle
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a> 
 * @date 2017年6月7日 下午4:55:59 
 * @version V1.0   
 */
package me.zhyd.springboot.handle;

import me.zhyd.springboot.exception.BadRequestException;
import me.zhyd.springboot.exception.NotFoundException;
import me.zhyd.springboot.exception.ZhangydException;
import me.zhyd.springboot.util.ExceptionResponse;
import me.zhyd.springboot.util.ExceptionResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 统一异常处理类<br>
 * 捕获程序所有异常，针对不同异常，采取不同的处理方式
 * 
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月7日 下午4:55:59
 * @version V1.0
 * @since JDK ： 1.7
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

	/**
	 * <strong>@ExceptionHandler</strong>指定需要捕获的异常类型<br>
	 * 捕获抛出的所有SQLException异常
	 * 
	 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
	 * @param request
	 * @param ex
	 * @return
	 * @since JDK 1.7
	 */
	@ExceptionHandler(SQLException.class)
	public ExceptionResponse handleSQLException(HttpServletRequest request, Exception ex) {
		return ExceptionResponseUtil.init(100001, "SQL异常！");
	}

	/**
	 * <strong>@ExceptionHandler</strong>指定需要捕获的异常类型<br>
	 * <strong>@ResponseStatus</strong>指定Http响应状态码：404<br>
	 * 捕获抛出的所有NotFoundException异常
	 * 
	 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
	 * @param ex
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ExceptionResponse handleNotFoundException(NotFoundException ex) {
		return ExceptionResponseUtil.init(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	/**
	 * <strong>@ExceptionHandler</strong>指定需要捕获的异常类型<br>
	 * <strong>@ResponseStatus</strong>指定Http响应状态码：400<br>
	 * 捕获抛出的所有BadRequestException异常
	 * 
	 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
	 * @param ex
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ExceptionResponse handleBadRequestException(BadRequestException ex) {
		return ExceptionResponseUtil.init(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	/**
	 * <strong>@ExceptionHandler</strong>指定需要捕获的异常类型<br>
	 * <strong>@ResponseStatus</strong>指定Http响应状态码：500<br>
	 * 捕获抛出的所有Exception异常<br>
	 * 其中又通过instanceof 判断具体的异常类型，针对异常类型做处理
	 * 
	 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
	 * @param request
	 * @param ex
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleServerErrorException(HttpServletRequest request, Exception ex) {
		String message = ex.getMessage();
		// Zhangyd异常
		if (ex instanceof ZhangydException) {
			ZhangydException ze = (ZhangydException) ex;
			return ExceptionResponseUtil.init(ze.getCode(), message);
		}
		return ExceptionResponseUtil.init(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

}
