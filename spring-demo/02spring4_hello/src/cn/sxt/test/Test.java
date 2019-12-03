package cn.sxt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.bean.Hello;


public class Test {
	public static void main(String[] args) {
		//����beans.xml�ļ� ���ɹ�����Ӧ��bean����
		BeanFactory context = new ClassPathXmlApplicationContext("beans.xml");
		//Hello hello = (Hello)context.getBean("h4");
		Hello hello= context.getBean(Hello.class);
		hello.show();
	}
}
