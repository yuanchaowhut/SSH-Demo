package cn.sxt.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInovationHandler implements InvocationHandler{
	private Object target;//Ŀ�����--��ʵ����
	public void setTarget(Object target) {
		this.target = target;
	}
	/**
	 * ���ɴ�����
	 * */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
	/**
	 * proxy�Ǵ�����
	 * method ������ĵ��ô������ķ�������
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("args="+args[0]);
		log(method.getName());
		Object result = method.invoke(target, args);
		return result;
	}
	public void log(String methodName){
		System.out.println("ִ��"+methodName+"����");
	}
}
