package me.zhyd.springboot.enums.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/7/3 9:47
 * @since 1.8
 */
public enum TypeEnum {
    ADMIN("管理员"),
    USER("普通用户");
    private String desc;

    TypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name());
        map.put("desc", this.getDesc());
        return JSONObject.toJSONString(map);
    }
}
