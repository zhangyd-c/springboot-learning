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
package com.zyd.model;

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
