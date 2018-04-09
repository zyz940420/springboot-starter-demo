package com.yuzhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhou.pojo.Resources;

@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerController {

	@Autowired
	private Resources resources;

	@RequestMapping(value = "/index")
	public String index(ModelMap map) {
		map.addAttribute("resource", resources);
		return "freemarker/index";
	}

	@RequestMapping(value = "/center")
	public String center() {
		return "freemarker/center/center";
	}
}
