package com.zyd.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.zyd.mybatis.service.IMessageService;

@Controller
public class MyabatisController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping("/{currentPage}/{pageSize}")
	public String index(Model model, @PathVariable("currentPage") Integer currentPage,
			@PathVariable("pageSize") Integer pageSize) {
		if (currentPage != null) {
			PageHelper.startPage(currentPage, pageSize);
		}
		model.addAttribute("list", messageService.list());
		int total = messageService.count();
		model.addAttribute("totalPage", total / pageSize + (total % pageSize > 0 ? 1 : 0));
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		return "index";
	}

}
