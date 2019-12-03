package cn.sxt.action;

import java.util.List;
import java.util.Map;

import cn.sxt.entity.User;
import cn.sxt.entity.Vip;
import cn.sxt.service.UserService;
import cn.sxt.service.VipService;

import com.opensymphony.xwork2.Action;

public class UserAction {
	private User user;
	private List<User> list;
	private List<Vip> vipList;
	private Map<Integer,String> map;
	private UserService userService = new UserService();
	private VipService vipService = new VipService();
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
		//vipList=vipService.getList();
		map = vipService.getMap();
		return Action.SUCCESS;
	}
	//����id��ѯ�û� Ȼ����ת��update.jsp
	public String toUpdate(){
		user = userService.getById(user.getId());
		map = vipService.getMap();
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
	public List<Vip> getVipList() {
		return vipList;
	}
	public void setVipList(List<Vip> vipList) {
		this.vipList = vipList;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	
}
