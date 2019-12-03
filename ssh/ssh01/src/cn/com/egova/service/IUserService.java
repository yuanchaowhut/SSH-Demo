package cn.com.egova.service;

import cn.com.egova.bean.User;

public interface IUserService {
	boolean register(User u);
	
	User getUserById(int id);
}
