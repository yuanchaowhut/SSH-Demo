package cn.com.egova.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.com.egova.bean.User;
import cn.com.egova.dao.UserDAO;
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
		user.setName("ÕÅÈý");
		user.setAge(28);
		user.setTel("18802775636");
		UserDAO dao = new UserDAO();
		dao.addUser(user);
	}
	
	
	@Test
	public void testGetUser(){
		UserDAO dao = new UserDAO();
		User user = dao.getUserById(1);
		System.out.println(user.toString());
	}
	
}
