package me.zhyd.springboot.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.model
 *
 * @Author: yadong.zhang
 * @Date: 2017/10/10 13:45
 */
public class Other {

    @Length(max = 18, min = 15, message = "身份证长度为15或者18位")
    private String idcard;

    @Pattern(regexp = "[0-9]{11}", message = "手机号格式错误")
    private String phone;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Other{" +
                "idcard='" + idcard + '\'' +
                ", phone=" + phone +
                '}';
    }
}
