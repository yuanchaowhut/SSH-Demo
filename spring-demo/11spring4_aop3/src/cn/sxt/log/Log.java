package cn.sxt.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
	@Before("execution(* cn.sxt.service.impl.*.*(..))")
	public void before(){
		System.out.println("-----����ִ��ǰ-----");
	}
	@After("execution(* cn.sxt.service.impl.*.*(..))")
	public void after(){
		System.out.println("-----����ִ�к�-----");
	}
	@Around("execution(* cn.sxt.service.impl.*.*(..))")
	public Object aroud(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("����ǰ");
		System.out.println("ǩ����"+jp.getSignature());
		//ִ��Ŀ�귽��
		 Object result = jp.proceed();
		System.out.println("���ƺ�");
		return result;
	}
}
