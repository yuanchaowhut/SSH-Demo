package cn.sxt.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String name;
	private String pwd;
	//������
	public String execute(){
		System.out.println(name+"---"+pwd);
		if("siggy".equals(name)&&"1111".equals(pwd)){
			//��ȡsession
			ActionContext.getContext().getSession().put("user", name);
			//��ȡrequest---HttpServletRequest�����attributes
			Map<String,Object> request = (Map)ActionContext.getContext().get("request");
			//��ȡapplication
			Map<String,Object> application=ActionContext.getContext().getApplication();
			//��ȡparameters
			Map<String,Object> parameters = ActionContext.getContext().getParameters();
			//�൱�� request.getParameter("name");
			System.out.println("name===="+((String[])parameters.get("name"))[0]);
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
