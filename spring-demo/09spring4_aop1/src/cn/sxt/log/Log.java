package cn.sxt.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Log implements MethodBeforeAdvice{
	/**
	 * @param method �����÷�������
	 * @param args �����õķ����Ĳ���
	 * @param target �����õķ�����Ŀ�����
	 * */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println(target.getClass().getName()+"��"+method.getName()+"������ִ��");
	}
}
