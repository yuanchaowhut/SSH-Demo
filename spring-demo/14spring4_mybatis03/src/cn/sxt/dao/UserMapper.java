package cn.sxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.sxt.vo.User;

public interface UserMapper {
	@Select("select * from user")
	public List<User> selectUser(); 
}
