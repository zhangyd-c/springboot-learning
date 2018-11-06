/**
 * Copyright [2016-2017] [yadong.zhang]
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.zhyd.springboot.mybatis.mapper;

import me.zhyd.springboot.mybatis.bean.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.testMybatis.mapper
 * @Author: yadong.zhang
 * @Date: 2017/8/8 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageAnnotationMapperTest {

    @Autowired
    private MessageAnnotationMapper messageAnnotationMapper;

    @Test
    public void testList() throws Exception {
        List<Message> list =messageAnnotationMapper.list();
        System.out.println(list.size());
    }

}
