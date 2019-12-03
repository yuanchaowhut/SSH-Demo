package cn.sxt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.bean.Hello;


public class Test {
	public static void main(String[] args) {
		//解析beans.xml文件 生成管理相应的bean对象
		BeanFactory context = new ClassPathXmlApplicationContext("beans.xml");
		//Hello hello = (Hello)context.getBean("h4");
		Hello hello= context.getBean(Hello.class);
		hello.show();
	}
}
