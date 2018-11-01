package me.zhyd.springboot.mybatis.service;

import java.util.List;

import me.zhyd.springboot.mybatis.entity.Message;

public interface IMessageService {

	List<Message> list();

	int count();

}
