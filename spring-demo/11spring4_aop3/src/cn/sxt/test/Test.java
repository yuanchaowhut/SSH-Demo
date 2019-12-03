package cn.sxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.service.UserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService)ac.getBean("userService");
		userService.delete();
	}
}
