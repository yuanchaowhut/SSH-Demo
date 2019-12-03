package cn.sxt.action;

import com.opensymphony.xwork2.Action;

import cn.sxt.entity.User;

public class UserAction {
	private User user;
	//зЂВс
	public String register(){
		System.out.println(user);
		return Action.SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
