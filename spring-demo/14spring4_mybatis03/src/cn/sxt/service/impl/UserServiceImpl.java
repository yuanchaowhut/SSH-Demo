package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.UserMapper;
import cn.sxt.service.UserService;
import cn.sxt.vo.User;

public class UserServiceImpl implements UserService{
	private UserMapper userMapper = null;
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public List<User> selectUser() {
		return userMapper.selectUser();
	}
}
