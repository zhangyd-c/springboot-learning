package me.zhyd.springboot.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.zhyd.springboot.mybatis.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/11/5 18:17
 * @since 1.8
 */
@Controller
public class MybatisController {

    @Autowired
    private IMessageService messageService;

    /**
     * 通过自定义的mapper xml查询
     *
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/listByMapperXml/{currentPage}/{pageSize}")
    public String listByMapperXml(Model model, @PathVariable("currentPage") int currentPage,
                                  @PathVariable("pageSize") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        model.addAttribute("selectTypeMsg", "通过自定义的mapper xml查询");
        model.addAttribute("selectType", "listByMapperXml");
        model.addAttribute("page", new PageInfo<>(messageService.listByMapperXml()));
        return "index";
    }

    /**
     * 通过通用mapper查询
     *
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/listByMapper/{currentPage}/{pageSize}")
    public String listByMapper(Model model, @PathVariable("currentPage") int currentPage,
                               @PathVariable("pageSize") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        model.addAttribute("selectTypeMsg", "通过通用mapper查询");
        model.addAttribute("selectType", "listByMapper");
        model.addAttribute("page", new PageInfo<>(messageService.listByMapper()));
        return "index";
    }

    /**
     * 通过注解查询
     *
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/listByAnnotation/{currentPage}/{pageSize}")
    public String listByAnnotation(Model model, @PathVariable("currentPage") int currentPage,
                                   @PathVariable("pageSize") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        model.addAttribute("selectTypeMsg", "通过注解查询");
        model.addAttribute("selectType", "listByAnnotation");
        model.addAttribute("page", new PageInfo<>(messageService.listByAnnotation()));
        return "index";
    }
}
