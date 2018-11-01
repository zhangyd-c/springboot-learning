package me.zhyd.springboot.mybatis.service.impl;

import java.util.List;

import me.zhyd.springboot.mybatis.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.zhyd.springboot.mybatis.mapper.MessageMapper;
import me.zhyd.springboot.mybatis.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public List<Message> list() {
		return messageMapper.list();
	}

	@Override
	public int count() {
		return messageMapper.count();
	}

}
