package me.zhyd.springboot.servlet;

import me.zhyd.springboot.servlet.config.filter.WebAppForIndexFilter;
import me.zhyd.springboot.servlet.config.listener.WebAppListener2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class ServletApplaction {

    /**
     * @Description 注册webAppForIndexFilter
     * @author zhangyd
     * @date 2017年4月7日 下午4:37:37
     */
    @Bean
    public FilterRegistrationBean webAppForIndexFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("webAppForIndexFilter");
        WebAppForIndexFilter webAppForIndexFilter = new WebAppForIndexFilter();
        registrationBean.setFilter(webAppForIndexFilter);
        registrationBean.setOrder(-1);
        List<String> urlList = new ArrayList<>();
        urlList.add("/servlet/index");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    /**
     * @Description 注册WebAppListener2
     * @author zhangyd
     * @date 2017年4月7日 下午5:18:01
     */
    @Bean
    public ServletListenerRegistrationBean<WebAppListener2> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<WebAppListener2> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new WebAppListener2());
        return servletListenerRegistrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServletApplaction.class, args);
    }
}
