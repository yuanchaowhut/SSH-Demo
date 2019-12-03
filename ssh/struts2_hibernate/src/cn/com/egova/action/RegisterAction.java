package cn.com.egova.action;

import com.opensymphony.xwork2.Action;

import cn.com.egova.bean.User;
import cn.com.egova.service.IUserService;
import cn.com.egova.service.UserServiceImpl;

public class RegisterAction {
	private User user;
	private IUserService service = new UserServiceImpl();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String register(){
		boolean result = service.register(user);
		if(result){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
}
