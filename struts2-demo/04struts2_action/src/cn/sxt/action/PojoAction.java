package cn.sxt.action;

import com.opensymphony.xwork2.Action;

public class PojoAction {
	public String execute(){
		System.out.println("pojo action");
		return Action.SUCCESS;
	}
}
