package cn.com.egova.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;

@Component("service")
public class UserServiceImpl implements IUserService{
	@Resource
	private UserDAO userDao;

	@Override
	public boolean register(User u) {
		userDao.addUser(u);
		return true;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
