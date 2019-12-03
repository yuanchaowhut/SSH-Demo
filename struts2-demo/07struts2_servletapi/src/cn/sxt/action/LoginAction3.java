package cn.sxt.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction3 {
	private String name;
	private String pwd;
	//处理方法
	public String execute(){
		System.out.println(name+"---"+pwd);
		if("siggy".equals(name)&&"1111".equals(pwd)){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", name);
			System.out.println("name===="+request.getParameter("name"));
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
