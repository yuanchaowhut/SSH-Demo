package cn.sxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.dao.UserDao;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)ac.getBean("userDao");
		List list = userDao.getAll();
		System.out.println(list.size());
	}
}
