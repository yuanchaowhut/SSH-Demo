package cn.com.egova.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.egova.bean.User;
import cn.com.egova.util.HibernateUtil;

public class UserDAO {
	
	public void addUser(User u){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	public User getUserById(int id){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = (User)session.get(User.class, id);
		tx.commit();
		return user;
	}
}
