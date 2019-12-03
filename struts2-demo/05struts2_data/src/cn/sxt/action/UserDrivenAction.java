package cn.sxt.action;

import cn.sxt.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UserDrivenAction implements ModelDriven<User>{
	private User user = new User();
	//ע��
	public String register(){
		System.out.println(user);
		return Action.SUCCESS;
	}
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
