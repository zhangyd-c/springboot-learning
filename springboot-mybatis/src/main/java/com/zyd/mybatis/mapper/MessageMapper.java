package com.zyd.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyd.mybatis.entity.Message;

/**
 * @Description
 * @author zhangyd
 * @date 2017年3月10日 下午2:42:45
 * @version V1.0
 * @since JDK ： 1.7
 * @modify
 * @Review
 */
@Repository
public interface MessageMapper {
	List<Message> list();

	int count();
}
