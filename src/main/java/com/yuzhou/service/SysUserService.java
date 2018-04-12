package com.yuzhou.service;

import java.util.List;

import com.yuzhou.pojo.SysUser;

public interface SysUserService {
	int saveUser(SysUser sysUser);

	int updateUser(SysUser sysUser);

	int deleteUser(String userId);

	SysUser queryUserById(String userId);

	List<SysUser> queryUserList(SysUser user);

	List<SysUser> queryUserListPaged(Integer pageNum, Integer pageSize);

	SysUser queryUserSimpleInfoById(String userId);

	int testTransaction(SysUser sysUser);

}
