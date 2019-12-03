package cn.sxt.action;

import com.opensymphony.xwork2.ActionSupport;

public class ExtendsAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("extends action");
		return SUCCESS;
	}

}
