package cn.sxt.service;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		//������ҵ��----��־����ȫ��Ȩ�ޣ����棬����ȵ�
		//A.log();---�����˼��--ֽ���Ķ�����osgi--javaģ�鿪��-spring--osgi
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
