package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Detail;

public interface DetailDao {
	public List<Detail> listByOrderId(int id);
	public int delete(int id);
}
