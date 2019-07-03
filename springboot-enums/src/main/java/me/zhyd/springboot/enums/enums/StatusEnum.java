package me.zhyd.springboot.enums.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/7/3 9:47
 * @since 1.8
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum StatusEnum {
    INUSE("使用中"),
    UNUSED("未使用"),
    DISABLED("已禁用");

    private String desc;

    StatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return this.name();
    }
}
