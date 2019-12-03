package cn.sxt.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import cn.sxt.entity.Point;

public class PointConverter extends StrutsTypeConverter{
	/**
	 * �����ύ���ַ������� ת��Ϊ ָ���Զ�������
	 * context ��ActionContext
	 * values Ҫ��������ת�����ַ�������
	 * toClass ��ת��������
	 * */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String value=values[0];
		Point point = new Point();
		String x = value.substring(1,value.indexOf(","));
		String y=value.substring(value.indexOf(",")+1,value.length()-1);
		System.out.println("x="+x);
		System.out.println("y="+y);
		point.setX(Integer.parseInt(x));
		point.setY(Integer.parseInt(y));
		return point;
	}
	/**
	 * ���������� ת��Ϊ�ַ�����ǰ̨ҳ����ʾ----ͨ��ognl���ʽ����ʹ�ø÷�������ת��
	 * context ---actionContext
	 * o  Ҫת���Ķ���
	 * */
	@Override
	public String convertToString(Map context, Object o) {
		Point point = (Point)o;
		return "("+point.getX()+","+point.getY()+")";
	}
}
