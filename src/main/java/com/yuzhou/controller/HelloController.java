package com.yuzhou.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuzhou.pojo.Resources;
import com.yuzhou.util.JsonResult;

@RestController
public class HelloController {
	@RequestMapping(value = "/hello")
	public Object hello() {
		return "hello yuzhou";
	}

	@Autowired
	private Resources resources;
	
	@RequestMapping("/resources")
	public JsonResult getResources() {
		Resources bean = new Resources();
		BeanUtils.copyProperties(resources, bean);
		return JsonResult.ok(bean);
	}
}
