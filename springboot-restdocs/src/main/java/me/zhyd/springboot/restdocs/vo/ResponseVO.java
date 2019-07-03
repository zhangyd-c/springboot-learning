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
