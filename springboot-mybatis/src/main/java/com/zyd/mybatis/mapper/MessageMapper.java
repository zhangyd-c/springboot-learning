package com.zyd.mybatis.mapper;

import com.zyd.mybatis.entity.Message;
import com.zyd.mybatis.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyd
 * @version V1.0
 * @Description
 * @date 2017年3月10日 下午2:42:45
 * @modify
 * @Review
 * @since JDK ： 1.7
 */
@Repository
public interface MessageMapper extends MyMapper<Message> {
    List<Message> list();

    int count();
}
