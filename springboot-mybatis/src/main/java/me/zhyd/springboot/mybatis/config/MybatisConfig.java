package me.zhyd.springboot.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/5 18:17
 * @since 1.8
 */
@Component
@MapperScan("me.zhyd.springboot.mybatis.mapper")
public class MybatisConfig {
}
