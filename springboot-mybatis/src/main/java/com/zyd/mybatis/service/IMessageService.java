package com.zyd.mybatis.service;

import java.util.List;

import com.zyd.mybatis.entity.Message;

public interface IMessageService {

	List<Message> list();

	int count();

}
