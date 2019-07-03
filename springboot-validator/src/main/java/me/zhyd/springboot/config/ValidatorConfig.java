package me.zhyd.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.config
 * @Author: yadong.zhang
 * @Date: 2017/10/10 13:43
 */
@Configuration
@Order(0)
public class ValidatorConfig extends WebMvcConfigurerAdapter {

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
