package cn.sxt.service;

import java.util.List;
import java.util.Map;

import cn.sxt.dao.VipDao;
import cn.sxt.entity.Vip;

public class VipService {
	private VipDao vipDao = new VipDao();
	public List<Vip> getList(){
		return vipDao.getList();
	}
	public Map<Integer,String> getMap(){
		return vipDao.getMap();
	}
}
