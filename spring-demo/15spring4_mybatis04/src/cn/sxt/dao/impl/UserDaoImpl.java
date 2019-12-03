package cn.sxt.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import cn.sxt.dao.UserDao;
import cn.sxt.vo.User;

public class UserDaoImpl implements UserDao{
	private SqlSessionTemplate sqlSession;
	@Override
	public List<User> selectUser() {
		return sqlSession.selectList("cn.sxt.vo.user.mapper.selectAll");
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
