package cn.sxt.action;

import java.util.ArrayList;
import java.util.List;

public class UserAction {
	private String name;
	private String tel;
	private String email;
	private List<String> list;
	
	public String list(){
		System.out.println("name="+name+"  tel="+tel+"  email="+email);
		list = new ArrayList<String>();
		list.add("siggy");
		list.add("today is friday");
		list.add("it is funny");
		return "success";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
}
