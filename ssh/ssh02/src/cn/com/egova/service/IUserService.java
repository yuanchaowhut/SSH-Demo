package cn.com.egova.service;

import java.util.List;

import cn.com.egova.bean.User;

public interface IUserService {
	boolean register(User u);
	
	User getUserById(int id);
	
	List<User> getAllUsers();
	
	boolean update(User u);
	
	boolean delete(int id);
	
	boolean isExist(User u);
}
