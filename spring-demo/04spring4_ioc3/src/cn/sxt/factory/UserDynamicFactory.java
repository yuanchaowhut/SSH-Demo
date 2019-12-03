package cn.sxt.factory;

import cn.sxt.vo.User;

public class UserDynamicFactory {
	public User newInstance(String name){
		return new User(name);
	}
}
