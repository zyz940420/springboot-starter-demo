package com.yuzhou.mapper;

import java.util.List;

import com.yuzhou.pojo.SysUser;
import com.yuzhou.util.Mymapper;

public interface SysUserMapper extends Mymapper<SysUser> {
	List<SysUser> queryUserSimpleInfoById(String id);
}