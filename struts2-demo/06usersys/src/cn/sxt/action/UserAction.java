package cn.sxt.action;

import java.util.List;

import cn.sxt.entity.User;
import cn.sxt.service.UserService;

import com.opensymphony.xwork2.Action;

public class UserAction {
	private User user;
	private List<User> list;
	private UserService userService = new UserService();
	//登录
	public String login(){
		User temp=userService.login(user);
		if(temp!=null){
			//list = userService.getList();
			return Action.SUCCESS;
		}
		return Action.LOGIN;
	}
	//获取用户列表
	public String list(){
		list = userService.getList();
		return Action.SUCCESS;
	}
	//根据id查询用户 然后跳转到update.jsp
	public String toUpdate(){
		user = userService.getById(user.getId());
		return Action.SUCCESS;
	}
	//更新用户
	public String update(){
		int result=userService.update(user);
		if(result>0){
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
}
