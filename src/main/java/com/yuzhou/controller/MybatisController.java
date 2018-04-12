package com.yuzhou.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuzhou.pojo.SysUser;
import com.yuzhou.service.SysUserService;
import com.yuzhou.util.JsonResult;

@RestController
@RequestMapping(value = "/mybatis")
public class MybatisController {
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private Sid sid;

	@RequestMapping(value = "/saveUser")
	public JsonResult saveSysUser() {
		SysUser sysUser = new SysUser();
		sysUser.setId(sid.nextShort());
		sysUser.setUsername("zyz" + new Date());
		sysUser.setNickname("zyz" + new Date());
		sysUser.setPassword("abc111");
		sysUser.setIsDelete(0);
		sysUser.setRegistTime(new Date());

		int count = sysUserService.saveUser(sysUser);
		return JsonResult.ok(count);
	}

	@RequestMapping(value = "/updateUser")
	public JsonResult updateUser() {
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		int count = sysUserService.updateUser(user);
		return JsonResult.ok(count);
	}

	@RequestMapping(value = "/deleteUser")
	public JsonResult deleteUser(String userId) {
		int count = sysUserService.deleteUser(userId);
		return JsonResult.ok(count);
	}

	@RequestMapping(value = "/queryUserById")
	public JsonResult queryUserById(String userId) {
		return JsonResult.ok(sysUserService.queryUserById(userId));
	}

	@RequestMapping(value = "/queryUserList")
	public JsonResult queryUserList() {

		SysUser user = new SysUser();
		user.setUsername("zyz");
		user.setNickname("zyz");

		List<SysUser> userList = sysUserService.queryUserList(user);
		return JsonResult.ok(userList);
	}

	@RequestMapping(value = "/queryUserListPaged")
	public JsonResult queryUserListPaged(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		Integer pageSize = 10;
		List<SysUser> userList = sysUserService.queryUserListPaged(pageNum, pageSize);

		return JsonResult.ok(userList);
	}
	
	@RequestMapping(value="/queryUserSimpleInfoById")
	public JsonResult queryUserSimpleInfoById(String userId) {
		SysUser sysUser = sysUserService.queryUserSimpleInfoById(userId);
		return JsonResult.ok(sysUser);
	}
	@RequestMapping(value="/transaction")
	public JsonResult testTransaction() {
		SysUser sysUser = new SysUser();
		sysUser.setId(sid.nextShort());
		sysUser.setUsername("transaction" + new Date());
		sysUser.setNickname("transaction" + new Date());
		sysUser.setPassword("abc222");
		sysUser.setIsDelete(0);
		sysUser.setRegistTime(new Date());
		sysUserService.testTransaction(sysUser);
		return JsonResult.ok("success");
	}

}
