package cn.sxt.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import cn.sxt.entity.User;

public class JsonAction {
	private JSONArray root;
	public String execute(){
		List<User> list = new ArrayList<User>();
		list.add(new User("siggy",23));
		list.add(new User("zhangsan",22));
		list.add(new User("老王",21));
		root = JSONArray.fromObject(list);
		System.out.println("json="+root.toString());
		return "success";
	}
	public JSONArray getRoot() {
		System.out.println("获取root数据");
		return root;
	}

	public void setRoot(JSONArray root) {
		this.root = root;
	}
	
}
