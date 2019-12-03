package cn.com.egova.test;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;
import cn.com.egova.service.IUserService;

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
		user.setName("张三");
		user.setAge(272);
		user.setTel("1880275637");
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
	
	@Test
	public void testIsExist(){
		User user = new User();
		user.setName("张三");
		user.setAge(25);
		user.setTel("18802775636");
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService service = (IUserService) act.getBean("userService");
		boolean isExist = service.isExist(user);
		System.out.print(isExist?"登陆成功!":"登陆失败!");
	}
	
	@Test
	public void testUpdate(){
		User user = new User();
		user.setName("张三丰");
		user.setAge(25);
		user.setTel("18802775636");
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService service = (IUserService) act.getBean("userService");
		service.update(user);
	}
	
	@Test
	public void testDelete(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService service = (IUserService) act.getBean("userService");
		service.delete(1);
	}
	
	@Test
	public void testGetAllUser(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService service = (IUserService) act.getBean("userService");
		List<User> list = service.getAllUsers();
		System.out.print(list.toString());
	}
}
