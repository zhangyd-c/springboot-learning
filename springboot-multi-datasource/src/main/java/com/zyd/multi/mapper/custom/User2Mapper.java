package com.zyd.multi.mapper.custom;

import com.zyd.multi.entity.Users;
import com.zyd.multi.plugin.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Mapper extends MyMapper<Users> {
    List<Users> selectAllByXml();
}