package cn.sxt.service.impl;

import cn.sxt.dao.UserDao;
import cn.sxt.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao=null;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void getUser() {
		userDao.getUser();
	}
}
