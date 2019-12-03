package cn.sxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.dao.DetailDao;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DetailDao orderDao = (DetailDao)ac.getBean("detailDao");
		System.out.println(orderDao.listByOrderId(1).size());
	}
}
