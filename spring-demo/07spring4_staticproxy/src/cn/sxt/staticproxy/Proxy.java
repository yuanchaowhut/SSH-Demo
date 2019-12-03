package cn.sxt.staticproxy;

public class Proxy implements Rent{
	private Host host;
	public Proxy() {
	}
	public Proxy(Host host) {
		this.host = host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	//租房
	public void rent(){
		seeHouse();
		host.rent();
		fare();
	}
	//看房
	private void seeHouse(){
		System.out.println("带房客看房");
	}
	//收中介费
	private void fare(){
		System.out.println("收取中介费");
	}
}
