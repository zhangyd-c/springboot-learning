package com.zyd.multi.mapper.primary;


import com.zyd.multi.entity.Users;
import com.zyd.multi.plugin.MyMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional("primaryTestTransactionManager")
public interface User1Mapper extends MyMapper<Users>{
    List<Users> selectAllByXml();
}