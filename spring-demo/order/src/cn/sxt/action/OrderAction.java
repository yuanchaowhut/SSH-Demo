package cn.sxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.sxt.service.DetailService;
import cn.sxt.service.OrderService;
import cn.sxt.vo.Detail;
import cn.sxt.vo.Order;

@Controller
@Scope("prototype")
public class OrderAction {
	private List<Order> list;
	private List<Detail> details;
	private int orderId;
	private int detailId;
	@Autowired
	private OrderService orderService;
	@Autowired
	private DetailService detailService;
	
	//��ȡ���ж���---getList
	public String list(){
		list = orderService.list();
		return "success";
	}
	//��ȡ��������
	public String detail(){
		details = detailService.listByOrderId(orderId);
		return "success";
	}
	//ɾ�����������е�һ��
	public String delete(){
		detailService.delete(orderId, detailId);
		return "success";
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public DetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
}
