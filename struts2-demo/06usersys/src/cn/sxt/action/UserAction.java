package cn.sxt.action;

import java.util.List;

import cn.sxt.entity.User;
import cn.sxt.service.UserService;

import com.opensymphony.xwork2.Action;

public class UserAction {
	private User user;
	private List<User> list;
	private UserService userService = new UserService();
	//��¼
	public String login(){
		User temp=userService.login(user);
		if(temp!=null){
			//list = userService.getList();
			return Action.SUCCESS;
		}
		return Action.LOGIN;
	}
	//��ȡ�û��б�
	public String list(){
		list = userService.getList();
		return Action.SUCCESS;
	}
	//����id��ѯ�û� Ȼ����ת��update.jsp
	public String toUpdate(){
		user = userService.getById(user.getId());
		return Action.SUCCESS;
	}
	//�����û�
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
