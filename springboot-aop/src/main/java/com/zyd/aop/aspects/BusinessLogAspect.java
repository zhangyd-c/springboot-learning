/**
 * Copyright [2016-2017] [yadong.zhang]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyd.aop.aspects;

import com.zyd.aop.annotation.BusinessLogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.aop.aspects
 *
 * @Author: yadong.zhang
 * @Date: 2017/10/10 12:56
 */
@Component
@Aspect
@Order(-5)
public class BusinessLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessLogAspect.class);

    @Pointcut(value = "@annotation(com.zyd.aop.annotation.BusinessLogAnnotation)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint point) throws NoSuchMethodException {
        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            LOGGER.error("该注解只能用于方法");
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        //获取拦截方法的参数
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        //获取操作业务的名称
        BusinessLogAnnotation annotation = currentMethod.getAnnotation(BusinessLogAnnotation.class);
        String bussinessName = annotation.value();
        LOGGER.info("进入{}方法...", bussinessName);

    }
}
