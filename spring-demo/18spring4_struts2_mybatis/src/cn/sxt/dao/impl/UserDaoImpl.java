package cn.sxt.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.sxt.dao.UserDao;
import cn.sxt.vo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	public List<User> getAll() {
		return this.getSqlSession().selectList("cn.sxt.vo.user.mapper.getAll");
	}
	public int add(User user){
		return this.getSqlSession().insert("cn.sxt.vo.user.mapper.add", user);
	}
	public int remove(int id){
		return this.getSqlSession().delete("cn.sxt.vo.user.mapper.remove", id);
	}
}
