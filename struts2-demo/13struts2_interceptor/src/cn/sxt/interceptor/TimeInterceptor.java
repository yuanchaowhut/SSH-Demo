package cn.sxt.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/***
 *计算action执行时间 
 */
public class TimeInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start=System.currentTimeMillis();
		//执行下一个拦截器，当拦截器执行完后执行action
		String result= invocation.invoke();
		long end=System.currentTimeMillis();
		System.out.println("执行该Action所用时间为："+(end-start)+"ms");
		return result;
	}
}
