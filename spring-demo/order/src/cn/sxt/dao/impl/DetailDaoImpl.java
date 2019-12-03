package cn.sxt.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.DetailDao;
import cn.sxt.vo.Detail;
@Repository("detailDao")
public class DetailDaoImpl extends SqlSessionDaoSupport implements DetailDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int delete(int id) {
		return getSqlSession().delete("cn.sxt.vo.detail.mapper.delete", id);
	}
	@Override
	public List<Detail> listByOrderId(int id) {
		return getSqlSession().selectList("cn.sxt.vo.detail.mapper.listByOrderId", id);
	}
}
