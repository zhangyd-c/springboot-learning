package me.zhyd.springboot.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * springboot
 * Created by yadong.zhang on me.zhyd.springboot.aop.annotation
 *
 * @Author: yadong.zhang
 * @Date: 2017/10/10 12:55
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLogAnnotation {

    /**
     * 业务的名称
     */
    String value() default "";
}
