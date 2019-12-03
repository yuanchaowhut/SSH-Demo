package cn.com.egova.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;

@Component("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean register(User u) {
		User user = null;
		if(u.getId()>0){
			user = userDAO.getUserById(u.getId());
			System.out.print(user.toString());
		}
		if(user==null){
			userDAO.addUser(u);
			System.out.print("新增用户成功!");
			return true;
		}else{
			System.out.print("用户已存在!");
			return false;
		}	
	}
}
