package me.zhyd.springboot.multi.mapper.custom;

import me.zhyd.springboot.multi.entity.Users;
import me.zhyd.springboot.multi.plugin.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Mapper extends MyMapper<Users> {
    List<Users> selectAllByXml();
}