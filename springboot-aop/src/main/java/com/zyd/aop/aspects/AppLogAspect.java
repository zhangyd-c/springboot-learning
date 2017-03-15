package com.zyd.aop.aspects;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <strong>Order</strong> 定义切面执行的优先级，数字越低，优先级越高 <br>
 * 在切入点之前执行：按order值有小到大的顺序执行  <br>
 * 在切入点之后执行：按order值由大到小的顺序执行
 */
@Component
@Aspect
@Order(-5)
public class AppLogAspect {

	// 保证每个线程都有一个单独的实例
	private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

	@Pointcut("execution(* com.zyd.aop.controller.AopController.*(..))")
	public void aop() {
	}

	@Before("aop()")
	public void doBefore(JoinPoint joinPoint) {
		threadLocal.set(System.currentTimeMillis());

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attributes.getRequest();

		// 记录请求的内容
		System.out.println("Request URL: " + request.getRequestURL().toString());
		System.out.println("Request Method: " + request.getMethod());

		System.out.println("IP: " + request.getRemoteAddr());
		System.out.println("User-Agent: " + request.getHeader("User-Agent"));
		System.out.println("Class Method: " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		System.out.println("Cookies: " + request.getCookies());

		System.out.println("Params: " + Arrays.toString(joinPoint.getArgs()));

		Enumeration<String> enums = request.getParameterNames();
		while (enums.hasMoreElements()) {
			String paraName = enums.nextElement();
			System.out.println(paraName + ":" + request.getParameter(paraName));
		}
	}

	@After("aop()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("doAfter(): " + joinPoint.toString());
	}

	@AfterReturning("aop()")
	public void doAfterReturning(JoinPoint joinPoint) {
		System.out.println("耗时 : " + ((System.currentTimeMillis() - threadLocal.get())) + "ms");
		System.out.println("AppLogAspect.doAfterReturning()");
	}
}
