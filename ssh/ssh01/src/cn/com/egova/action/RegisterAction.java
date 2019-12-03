package cn.com.egova.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import cn.com.egova.bean.User;
import cn.com.egova.service.IUserService;
import cn.com.egova.service.UserServiceImpl;

@Controller
@Scope("prototype")
public class RegisterAction {
	private User user;
	@Resource
	private IUserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String register(){
		boolean result = userService.register(user);
		if(result){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
}
