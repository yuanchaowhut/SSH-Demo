package cn.sxt.test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
import cn.sxt.entity.User;

public class Test {
	public static void main(String[] args) throws OgnlException {
		//ԭ�����ݷ�Ϊ2�� ---���õĺͲ����õ�---���õ�һ����С���ݣ������õ�һ���Ǵ�����
		//���ʽ�����õ�����ֱ��ȡ�������õ����ݼ�#ȡ
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "������");
		map.put("age", 125);
		User user = new User();
		user.setName("lisi");
		Object obj = Ognl.getValue("#name", map, user);
		System.out.println(obj);
	}
}
