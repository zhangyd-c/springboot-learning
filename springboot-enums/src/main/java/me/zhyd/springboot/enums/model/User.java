package me.zhyd.springboot.enums.model;

import lombok.Data;
import me.zhyd.springboot.enums.enums.GenderEnum;
import me.zhyd.springboot.enums.enums.StatusEnum;
import me.zhyd.springboot.enums.enums.TypeEnum;

import java.io.Serializable;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/7/3 9:44
 * @since 1.8
 */
@Data
public class User implements Serializable {
    private String username;
    private String site;
    private String[] git;
    private GenderEnum gender;
    private TypeEnum type;
    private StatusEnum status;

    public String getTypeEnumDesc() {
        return null == type ? null : type.getDesc();
    }
}
