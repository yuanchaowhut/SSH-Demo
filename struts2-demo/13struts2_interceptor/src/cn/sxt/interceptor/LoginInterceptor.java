package cn.sxt.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//�ж��Ƿ���login.action �������ֱ��ִ����һ��������
		//������� ���ж��Ƿ��¼�������¼ִ����һ��������
		//���û���򷵻ص�¼ҳ��
		//actionNameû����չ��
		String actionName=invocation.getProxy().getActionName();
		if("login".equals(actionName)){
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if(obj==null){//û�е�¼
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
}
