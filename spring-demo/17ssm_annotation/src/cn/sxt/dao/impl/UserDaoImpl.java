package cn.sxt.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.UserDao;
import cn.sxt.vo.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public List<User> getAll() {
		return this.getSqlSession().selectList("cn.sxt.vo.user.mapper.getAll");
	}
}
