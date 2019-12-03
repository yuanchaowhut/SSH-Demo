package cn.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.OrderDao;
import cn.sxt.service.OrderService;
import cn.sxt.vo.Order;
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Override
	public List<Order> list() {
		return orderDao.list();
	}
}
