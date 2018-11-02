package me.zhyd.springboot.freemark.controller;

import me.zhyd.springboot.freemark.FreemarkerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class FreemarkController {

    @RequestMapping("/")
    public String index(Model model) {
        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());
        model.addAttribute("bol", true);
        return "index";
    }

    @RequestMapping("/createHtml")
    @ResponseBody
    public String createHtml(Model model){
        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());
        model.addAttribute("bol", true);
        return FreemarkerUtil.parseTpl("index", model.asMap());
    }
}
