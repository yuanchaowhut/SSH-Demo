package cn.sxt.factory;

import cn.sxt.vo.User;

public class UserFactory {
	public static User newInstance(String name){
		return new User(name);
	}
}