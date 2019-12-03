package cn.com.egova.dao;

import org.springframework.stereotype.Component;

import cn.com.egova.bean.User;


@Component
public class UserDAO {
	
	public void addUser(User u){
		System.out.print(u.toString());
	}
}
