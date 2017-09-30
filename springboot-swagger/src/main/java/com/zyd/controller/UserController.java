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
package com.zyd.controller;


import com.zyd.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.controller
 *
 * @Author: yadong.zhang
 * @Date: 2017/9/14 11:41
 */
@RestController
@RequestMapping("/demo")
@Api(value = "测试Swagger2",description="简单的API")
public class UserController {

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Long", name = "id", value = "id", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "User", name = "user", value = "用户信息", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "接口异常"),
    })
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public User insert(@PathVariable Long id, @RequestBody User user) {

        System.out.println("id:" + id + ", user:" + user);
        user.setId(id);

        return user;
    }

    @ApiOperation(value = "获取指定id用户详细信息", notes = "根据user的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {

        User user = new User();
        user.setId(id);
        user.setPassword("abc");
        user.setUsername("12345");
        return user;
    }

    @ApiOperation(value = "获取所有用户详细信息", notes = "获取用户列表信息")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList() {

        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(15L);
        user.setPassword("ricky");
        user.setUsername("root");

        list.add(user);

        return list;
    }

    @ApiIgnore
    @ApiOperation(value = "删除指定id用户", notes = "根据id来删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "java.lang.Long", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        System.out.println("delete user:" + id);
        return "OK";
    }
}
