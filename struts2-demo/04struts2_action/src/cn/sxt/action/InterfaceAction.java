package cn.sxt.action;

import com.opensymphony.xwork2.Action;

public class InterfaceAction implements Action{
	public String execute() throws Exception {
		System.out.println("interface action");
		return SUCCESS;
	}
}
