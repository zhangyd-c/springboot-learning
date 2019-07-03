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
