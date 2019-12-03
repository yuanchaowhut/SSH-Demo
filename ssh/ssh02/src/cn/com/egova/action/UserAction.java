package cn.com.egova.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;
import cn.com.egova.bean.User;
import cn.com.egova.service.IUserService;

@Controller
@Scope("prototype")
public class UserAction {
	private User user;
	private List<User> userList;
	@Resource
	private IUserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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
	
	public String login(){
		boolean isExist = userService.isExist(user);
		System.out.print(isExist?"µÇÂ¼³É¹¦!":"µÇÂ¼Ê§°Ü!");
		if(isExist){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	public String list(){
		userList = userService.getAllUsers();
		return Action.SUCCESS;
	}
	
	public String toUpdate(){
		user = userService.getUserById(user.getId());
		return Action.SUCCESS;
	}
	
	public String update(){
		boolean result = userService.update(user);
		if(result){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	public String delete(){
		boolean result = userService.delete(user.getId());
		if(result){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
}
