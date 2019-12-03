package cn.sxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.dao.UserDao;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		System.out.println(userDao.selectUser().size());
	}
}
