package me.zhyd.springboot.mybatis.mapper;

import me.zhyd.springboot.mybatis.bean.Message;
import me.zhyd.springboot.mybatis.util.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/5 18:17
 * @since 1.8
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {
    List<Message> listByMapperXml();
}
