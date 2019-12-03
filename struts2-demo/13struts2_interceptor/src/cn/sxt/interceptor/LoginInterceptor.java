package cn.sxt.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//判断是否是login.action 如果是则直接执行下一个拦截器
		//如果不是 则判断是否登录，如果登录执行下一个拦截器
		//如果没有则返回登录页面
		//actionName没有扩展名
		String actionName=invocation.getProxy().getActionName();
		if("login".equals(actionName)){
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if(obj==null){//没有登录
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
}
