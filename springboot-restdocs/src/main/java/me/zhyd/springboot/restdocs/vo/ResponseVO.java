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
package me.zhyd.springboot.restdocs.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.restdocs.vo
 * @Author: yadong.zhang
 * @Date: 2017/9/4 12:08
 */
@Getter
@Setter
public class ResponseVO<T> {

    private int statusCode;
    private String message;
    private T data;

    public ResponseVO(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
