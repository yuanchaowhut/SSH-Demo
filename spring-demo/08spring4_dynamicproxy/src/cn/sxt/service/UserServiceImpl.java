package cn.sxt.service;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("�����û�");
	}

	@Override
	public void update() {
		System.out.println("�޸��û�");
	}	

	@Override
	public void delete() {
		System.out.println("ɾ���û�");
	}

	@Override
	public void search() {
		System.out.println("��ѯ�û�");
	}

}
