package cn.sxt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction1 {
	private String name;
	private String pwd;
	//������
	public String execute(){
		System.out.println(name+"---"+pwd);
		if("siggy".equals(name)&&"1111".equals(pwd)){
			HttpServletRequest request=(HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
			request.getSession().setAttribute("user", name);
			System.out.println("name===="+request.getParameter("name"));
			return "success";
		}else{
			return "login";
		}
	}
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		System.out.println("�˳�");
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
