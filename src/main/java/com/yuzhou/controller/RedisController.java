package com.yuzhou.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yuzhou.pojo.SysUser;
import com.yuzhou.pojo.User;
import com.yuzhou.util.JsonResult;
import com.yuzhou.util.JsonUtils;
import com.yuzhou.util.RedisOperator;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private RedisOperator redisOperator;

	@RequestMapping("/test")
	public JsonResult test() {
		redisTemplate.opsForValue().set("zyz-cache", "zhangyuzhou");

		SysUser sysUser = new SysUser();
		sysUser.setId("1001010101");
		sysUser.setUsername("zyz" + new Date());
		sysUser.setNickname("zyz" + new Date());
		sysUser.setPassword("abc111");
		sysUser.setIsDelete(0);
		sysUser.setRegistTime(new Date());

		redisTemplate.opsForValue().set("111", JsonUtils.objectToJson(sysUser));
		SysUser user = JsonUtils.jsonToPojo((redisTemplate.opsForValue().get("111")), SysUser.class);

		return JsonResult.ok(user);
	}

	@RequestMapping("/operate")
	public JsonResult operateTest() {
		List<User> listUser = new ArrayList<>();
		for (int i = 0; i <= 6; i++) {
			User user = new User();
			user.setName("zyz" + i);
			user.setAge(18);
			user.setBirthday(new Date());
			user.setDesc("test" + 1);
			user.setPassword("11111");
			listUser.add(user);
		}
		redisOperator.set("json:info:userList", JsonUtils.objectToJson(listUser), 20000);
		String userListJson = redisOperator.get("json:info:userList");
		List<User> userListBean = (List<User>) JsonUtils.jsonToList(userListJson, User.class);

		return JsonResult.ok(userListBean);
	}

}
