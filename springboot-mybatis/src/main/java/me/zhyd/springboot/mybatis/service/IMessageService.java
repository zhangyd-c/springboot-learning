package me.zhyd.springboot.mybatis.service;

import java.util.List;

import me.zhyd.springboot.mybatis.bean.Message;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/5 18:17
 * @since 1.8
 */
public interface IMessageService {

	List<Message> listByMapperXml();

	List<Message> listByMapper();

	List<Message> listByAnnotation();

}
