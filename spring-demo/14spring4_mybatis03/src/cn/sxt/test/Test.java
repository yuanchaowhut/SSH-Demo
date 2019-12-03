package cn.sxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.service.UserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService)context.getBean("userService");
		System.out.println(userService.selectUser().size());
	}
}
