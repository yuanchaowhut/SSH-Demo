package cn.sxt.service.impl;

import cn.sxt.service.UserService;

public class UserServiceImpl implements UserService{
	@Override
	public void add() {
		System.out.println("-------添加用户数据-------");
	}
	@Override
	public int delete() {
		System.out.println("-------删除用户数据-------");
		return 1;
	}
}
