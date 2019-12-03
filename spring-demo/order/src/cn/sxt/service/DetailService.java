package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Detail;

public interface DetailService {
	public List<Detail> listByOrderId(int id);
	public int delete(int orderId,int detailId);
}
