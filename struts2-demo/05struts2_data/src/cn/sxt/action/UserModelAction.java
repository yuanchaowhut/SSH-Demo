package cn.sxt.action;

import cn.sxt.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UserModelAction implements ModelDriven<User>{
	private User user=new User();
	public String register(){
		System.out.println(user);
		return Action.SUCCESS;
	}
	public User getModel() {
		return user;
	}
}
