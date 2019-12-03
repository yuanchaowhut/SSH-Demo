package cn.sxt.action;

import com.opensymphony.xwork2.Action;

public class HelloAction {
	private String name;
	
	public String execute(){
		System.out.println("name:"+name);
		return Action.SUCCESS;
	}
	public String list(){
		System.out.println("list");
		return Action.SUCCESS;
	}
	public String add(){
		System.out.println("add");
		return Action.SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
