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

import com.zyd.model.Other;
import com.zyd.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.controller
 *
 * @Author: yadong.zhang
 * @Date: 2017/10/10 13:41
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index");
    }

    @RequestMapping("/saveUser")
    public ModelAndView saveUser(@Validated User user, BindingResult userResult, @Validated Other other, BindingResult otherResult, Model model) {
        List<Map<String, String>> errorList = new ArrayList<>();

        loadErrorList(userResult, errorList);
        loadErrorList(otherResult, errorList);

        model.addAttribute("user", user);
        model.addAttribute("other", other);
        model.addAttribute("errorList", errorList);
        return new ModelAndView("index");
    }

    private void loadErrorList(BindingResult userResult, List<Map<String, String>> errorList) {
        Map<String, String> map = null;
        if (userResult.hasErrors()) {
            List<FieldError> errors = userResult.getFieldErrors();
            for (FieldError error : errors) {
                map = new HashMap<String, String>();
                map.put("field", error.getField());
                map.put("message", error.getDefaultMessage());
                errorList.add(map);
            }
        }
    }
}
