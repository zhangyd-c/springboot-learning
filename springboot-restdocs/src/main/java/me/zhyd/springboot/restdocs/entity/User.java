/**
 * Copyright [2016-2017] [yadong.zhang]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.zhyd.springboot.restdocs.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.restdocs.entity
 *
 * @Author: yadong.zhang
 * @Date: 2017/9/4 09:29
 */
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;

    public User() {
    }

    public User(Integer id, String name, Integer age, Date birthday) {
        setId(id);
        setName(name);
        setAge(age);
        setBirthday(birthday);
    }
}
