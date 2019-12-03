package cn.sxt.vo;

public class User {
	public User(String name) {
		super();
		this.name = name;
	}

	private String name;
	public void show(){
		System.out.println("name="+name);
	}
}
