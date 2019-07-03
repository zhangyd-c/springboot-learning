package me.zhyd.springboot.enums;

import me.zhyd.springboot.enums.enums.GenderEnum;
import me.zhyd.springboot.enums.enums.StatusEnum;
import me.zhyd.springboot.enums.enums.TypeEnum;
import me.zhyd.springboot.enums.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/7/3 9:49
 * @since 1.8
 */
@RestController
public class RestApiController {

    @RequestMapping("/users")
    public Object users() {
        List<User> userList = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 2; i++) {
            user = new User();
            user.setGender(i % 2 == 0 ? GenderEnum.MALE : GenderEnum.FAMALE);
            user.setType(i % 2 == 0 ? TypeEnum.ADMIN : TypeEnum.USER);
            user.setStatus(i % 2 == 0 ? StatusEnum.INUSE : StatusEnum.DISABLED);
            user.setUsername("user_" + i);
            user.setSite("https://www.zhyd.me");
            user.setGit(new String[]{"https://gitee.com/yadong.zhang", "https://github.com/zhangyd-c"});
            userList.add(user);
        }
        return userList;
    }
//    @RequestMapping(value = "/saveUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/saveUser")
    public Object saveUser(User user) {
        return user;
    }

}
