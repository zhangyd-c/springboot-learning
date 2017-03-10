package com.zyd.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyd.mybatis.entity.Message;
import com.zyd.mybatis.mapper.MessageMapper;
import com.zyd.mybatis.service.IMessageService;

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
