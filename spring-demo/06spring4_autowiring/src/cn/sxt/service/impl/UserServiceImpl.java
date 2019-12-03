package cn.sxt.service.impl;

import cn.sxt.dao.UserDao;
import cn.sxt.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao=null;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	public void getUser() {
		userDao.getUser();
	}
}
