package cn.com.egova.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.egova.bean.User;

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
		String hql = "select u from User u where u.tel=?";
		User existUser = null;
		List<User> list = (List<User>) hibernateTemplate.find(hql, u.getTel());
		if(list!=null && list.size()>0){
			existUser = list.get(0);
		}
		return existUser;
	}
	
	public void updateUser(User u){
		hibernateTemplate.clear();
		hibernateTemplate.update(u);
	}
	
	public void deleteUser(User u){
		hibernateTemplate.delete(u);
	}
	
	public List<User> getAllUsers(){
		String hql = "select u from User u";
		List<User> list = (List<User>) hibernateTemplate.find(hql);
		return list;
	}
}
