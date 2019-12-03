package cn.sxt.entity;
public class User {
	private int id;
	private String name;
	private String pwd;
	private int vipId;
	public User() {
	}
	


	public User(String name, String pwd, int vipId) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.vipId = vipId;
	}



	public User(int id, String name, String pwd, int vipId) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.vipId = vipId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
}
