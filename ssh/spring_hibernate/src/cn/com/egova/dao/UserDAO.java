package cn.com.egova.dao;

import javax.annotation.Resource;

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
}
