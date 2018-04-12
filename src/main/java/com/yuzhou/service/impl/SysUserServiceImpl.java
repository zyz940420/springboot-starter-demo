package com.yuzhou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.yuzhou.mapper.SysUserMapper;
import com.yuzhou.pojo.SysUser;
import com.yuzhou.service.SysUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper mapper;

	@Override
	public int saveUser(SysUser sysUser) {
		return mapper.insert(sysUser);
	}

	@Override
	public int updateUser(SysUser sysUser) {
		return mapper.updateByPrimaryKey(sysUser);
	}

	@Override
	public int deleteUser(String userId) {
		return mapper.deleteByPrimaryKey(userId);
	}

	@Override
	public SysUser queryUserById(String userId) {
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(user.getUsername())) {
			criteria.andLike("username", "%" + user.getUsername() + "%");
		}
		if (!StringUtils.isEmpty(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}

		return mapper.selectByExample(example);
	}

	@Override
	public List<SysUser> queryUserListPaged(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(SysUser.class);
		example.orderBy("registTime").desc();
		return mapper.selectByExample(example);
	}

	@Override
	public SysUser queryUserSimpleInfoById(String userId) {
		List<SysUser> userList = mapper.queryUserSimpleInfoById(userId);
		if (!CollectionUtils.isEmpty(userList)) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public int testTransaction(SysUser sysUser) {
		int saveCount = mapper.insert(sysUser);
		int data = 1/0;
		sysUser.setIsDelete(1);
		int updateCount = mapper.updateByPrimaryKeySelective(sysUser);
		return saveCount;
	}

}
