package com.yuzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhou.util.JsonResult;

@Controller
@RequestMapping(value = "/err")
public class ErrorController {
	
	@RequestMapping(value = "/error")
	public String error() {
		int a = 1 / 0;
		return "thymeleaf/error";
	}

	@RequestMapping(value = "/ajaxerror")
	public String ajaxError() {
		System.out.println("--------------");
		
		return "thymeleaf/ajaxerror";
	}

	@RequestMapping(value = "/getAjaxerror")
	@ResponseBody
	public JsonResult getAjaxerror() {
		System.out.println("------------");
		int a = 1 / 0;
		return JsonResult.ok();
	}
}
