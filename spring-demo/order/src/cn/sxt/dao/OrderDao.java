package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Order;

public interface OrderDao {
	public List<Order> list();
	public int update(Order order);
	public Order getById(int id);
}
