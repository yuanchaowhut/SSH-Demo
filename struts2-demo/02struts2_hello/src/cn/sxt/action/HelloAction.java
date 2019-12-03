package cn.sxt.action;

public class HelloAction {
	public HelloAction() {
		System.out.println("constructor");
	}
	public String execute(){
		System.out.println("hello struts2");
		return "success";
	}
}
