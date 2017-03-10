package com.zyd.freemark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
}
