package cn.com.egova.service;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;

public class UserServiceImpl implements IUserService{
	UserDAO dao = new UserDAO();

	@Override
	public boolean register(User u) {
		User user = dao.getUserById(u.getId());
		if(user!=null){  //ÒÑ´æÔÚ
			return false;
		}else{
			dao.addUser(u);
			return true;
		}
	}

}
