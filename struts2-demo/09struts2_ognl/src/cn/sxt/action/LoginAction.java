package cn.sxt.action;


import cn.sxt.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction {
	private String name;
	private String pwd;
	//处理方法
	public String execute(){
		System.out.println(name+"---"+pwd);
		if("siggy".equals(name)&&"1111".equals(pwd)){
			//获取session
			ActionContext.getContext().getSession().put("user", name);
			ValueStack vs = ActionContext.getContext().getValueStack();
			System.out.println("name======"+vs.findString("name"));
			User user = new User();
			user.setName("张三疯");
			vs.push(user);
			return "success";
		}else{
			return "login";
		}
	}
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
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
