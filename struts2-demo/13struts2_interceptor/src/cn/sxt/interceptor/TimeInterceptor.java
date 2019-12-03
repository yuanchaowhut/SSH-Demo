package cn.sxt.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/***
 *����actionִ��ʱ�� 
 */
public class TimeInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start=System.currentTimeMillis();
		//ִ����һ������������������ִ�����ִ��action
		String result= invocation.invoke();
		long end=System.currentTimeMillis();
		System.out.println("ִ�и�Action����ʱ��Ϊ��"+(end-start)+"ms");
		return result;
	}
}
