package com.yuzhou.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhou.pojo.User;
import com.yuzhou.util.JsonResult;

@Controller
public class UserController {

	@RequestMapping(value = "/user")
	public User getUser() {
		User user = new User();
		user.setName("yuzhou");
		user.setAge(18);
		user.setBirthday(new Date());
		user.setPassword("yuzhou");
		user.setDesc("yuzhou");

		return user;
	}

	@RequestMapping(value = "/userJson")
	public JsonResult getUserJson() {
		User user = new User();
		user.setName("yuzhou,yuzhou");
		user.setAge(18);
		user.setBirthday(new Date());
		user.setPassword("yuzhou");
		// user.setDesc(null);

		return JsonResult.ok(user);
	}
	
}
