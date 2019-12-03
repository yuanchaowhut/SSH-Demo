package cn.com.egova.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;

@Component("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public boolean register(User u) {
		User user = userDAO.isUserExist(u);  		
		if(user==null){
			userDAO.addUser(u);
			System.out.print("新增用户成功!");
			return true;
		}else{
			System.out.print("用户已存在!"+user.toString());
			return false;
		}	
	}

	@Override
	public User getUserById(int id) {
		User user = userDAO.getUserById(id);
		return user;
	}

	@Override
	public boolean update(User u) {
		User user = userDAO.getUserById(u.getId());   //根据手机号判断用户是否存在.
		if(user!=null){
			u.setId(user.getId());   //把从数据库取出的id设置给要修改的对象(因为u的id前台无法知道)
			userDAO.updateUser(u);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		User user = getUserById(id);
		if(user!=null){
			userDAO.deleteUser(user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDAO.getAllUsers();
		return users;
	}

	@Override
	public boolean isExist(User u) {
		boolean isExist = false;
		User user = userDAO.isUserExist(u);
		if(user!=null){
			isExist = true;
		}
		return isExist;
	}

}
