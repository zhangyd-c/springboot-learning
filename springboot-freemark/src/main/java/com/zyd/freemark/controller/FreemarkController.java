package com.zyd.freemark.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FreemarkController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload(Model model) {
		return "upload";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile[] files, String name,HttpServletRequest request) {
		if(files != null){
			for(MultipartFile file : files){
				System.out.println(file.getOriginalFilename());
			}
		}
		System.out.println(request.getParameter("name"));
		return name;
	}
}
