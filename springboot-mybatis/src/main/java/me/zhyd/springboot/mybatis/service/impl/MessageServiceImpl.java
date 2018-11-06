package me.zhyd.springboot.mybatis.service.impl;

import me.zhyd.springboot.mybatis.bean.Message;
import me.zhyd.springboot.mybatis.mapper.MessageAnnotationMapper;
import me.zhyd.springboot.mybatis.mapper.MessageMapper;
import me.zhyd.springboot.mybatis.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/5 18:17
 * @since 1.8
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageAnnotationMapper annotationMapper;

    @Override
    public List<Message> listByMapperXml() {
        return messageMapper.listByMapperXml();
    }

    @Override
    public List<Message> listByMapper() {
        return messageMapper.selectAll();
    }

    @Override
    public List<Message> listByAnnotation() {
        return annotationMapper.list();
    }

}
