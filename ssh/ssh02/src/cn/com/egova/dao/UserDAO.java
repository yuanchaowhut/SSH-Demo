package cn.com.egova.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.egova.bean.User;

//@Transactional
@Component
public class UserDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addUser(User u) {
		hibernateTemplate.save(u);
	}

	public User getUserById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}
	
	public User isUserExist(User u){
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "from User u where u.tel=?";
		User user = (User) session.createQuery(hql)
			   .setParameter(0, u.getTel())
			   .uniqueResult();
		return user;
	}
	
	public void updateUser(User u){
		hibernateTemplate.update(u);
	}
	
	public void deleteUser(User u){
		hibernateTemplate.delete(u);
	}
	
	public List<User> getAllUsers(){
		//注意这个地方一定要用getCurrentSession,不能用openSession.
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "from User";
		List<User> list = session.createQuery(hql).list();
		return list;
	}
}
