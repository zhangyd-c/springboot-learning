package me.zhyd.springboot.enums.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/7/3 9:46
 * @since 1.8
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenderEnum {
    MALE("男"),
    FAMALE("女");
    private String desc;

    GenderEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
