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
	//�ⷿ
	public void rent(){
		seeHouse();
		host.rent();
		fare();
	}
	//����
	private void seeHouse(){
		System.out.println("�����Ϳ���");
	}
	//���н��
	private void fare(){
		System.out.println("��ȡ�н��");
	}
}
