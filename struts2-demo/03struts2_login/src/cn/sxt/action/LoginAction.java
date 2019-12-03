package cn.sxt.action;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String name;
	private String pwd;
	//处理方法
	public String execute(){
		System.out.println(name+"---"+pwd);
		if("siggy".equals(name)&&"1111".equals(pwd)){
			ActionContext.getContext().getSession().put("user", name);
			return "success";
		}else{
			return "login";
		}
	}
	public String logout(){
		System.out.println("退出");
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
