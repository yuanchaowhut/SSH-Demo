package cn.com.egova.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;
import cn.com.egova.service.IUserService;
import cn.com.egova.util.HibernateUtil;

public class UserTest {
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setName("ÀîËÄ");
		user.setAge(25);
		user.setTel("18802775636");
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService service = (IUserService) act.getBean("userService");
		service.register(user);
	}
	
	
	@Test
	public void testGetUser(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO dao = (UserDAO) act.getBean("userDAO");
		User user = dao.getUserById(1);
		System.out.println(user.toString());
	}
	
}
