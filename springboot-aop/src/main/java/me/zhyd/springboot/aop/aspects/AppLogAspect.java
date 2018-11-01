package me.zhyd.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * <strong>Order</strong> 定义切面执行的优先级，数字越低，优先级越高 <br>
 * 在切入点之前执行：按order值有小到大的顺序执行  <br>
 * 在切入点之后执行：按order值由大到小的顺序执行
 */
@Component
@Aspect
@Order(-5)
public class AppLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLogAspect.class);
    // 保证每个线程都有一个单独的实例
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* me.zhyd.springboot.aop.controller.AopController.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求的内容
        LOGGER.info("Request URL: {}", request.getRequestURL().toString());
        LOGGER.info("Request Method: {}", request.getMethod());
        LOGGER.info("IP: {}", request.getRemoteAddr());
        LOGGER.info("User-Agent:{}", request.getHeader("User-Agent"));
        LOGGER.info("Class Method:{}", joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName());
        LOGGER.info("Cookies:{}", request.getCookies());
        LOGGER.info("Params:{}", Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            LOGGER.info(paraName + ":" + request.getParameter(paraName));
        }
    }

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("doAfter():{}", joinPoint.toString());
    }

    @AfterReturning("pointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        LOGGER.info("耗时 :{}", ((System.currentTimeMillis() - threadLocal.get())) + "ms");
    }
}
