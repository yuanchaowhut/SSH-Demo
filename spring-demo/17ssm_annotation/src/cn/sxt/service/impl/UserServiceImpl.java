package cn.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.UserDao;
import cn.sxt.service.UserService;
import cn.sxt.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<User> getAll() {
		return userDao.getAll();
	}
}
