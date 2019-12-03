package cn.sxt.test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
import cn.sxt.entity.User;

public class Test {
	public static void main(String[] args) throws OgnlException {
		//原则：数据分为2类 ---常用的和不常用的---常用的一般是小数据，不常用的一般是大数据
		//表达式：常用的数据直接取，不常用的数据加#取
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "张三疯");
		map.put("age", 125);
		User user = new User();
		user.setName("lisi");
		Object obj = Ognl.getValue("#name", map, user);
		System.out.println(obj);
	}
}
