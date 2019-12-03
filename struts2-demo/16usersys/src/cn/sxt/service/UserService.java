package cn.sxt.service;

import java.util.List;

import cn.sxt.dao.UserDao;
import cn.sxt.entity.User;

public class UserService {
	private UserDao userDao = new UserDao();
	public User login(User u){
		return userDao.login(u);
	}
	public List<User> getList(){
		return userDao.getList();
	}
	public int update(User u){
		return userDao.update(u);
	}
	public User getById(int id){
		return userDao.getById(id);
	}
}
