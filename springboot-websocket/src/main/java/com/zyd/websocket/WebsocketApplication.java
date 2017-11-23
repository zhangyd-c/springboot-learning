package com.zyd.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.websocket
 *
 * @author: yadong.zhang
 * @date: 2017/11/23 13:42
 */
@Controller
@SpringBootApplication
public class WebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
