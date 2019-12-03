package cn.sxt.bean;

public class Hello {
	public Hello() {
		System.out.println("hello ±»´´½¨");
	}
	private String name;
	private boolean sex;
	
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void show(){
		System.out.println("hello,"+name);
	}
}
