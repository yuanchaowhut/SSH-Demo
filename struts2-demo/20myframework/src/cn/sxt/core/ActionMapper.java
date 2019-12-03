package cn.sxt.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ActionMapper {
	public static Map<String,Action> actionMap = new HashMap<String,Action>();
	public static void parser() throws DocumentException{
		InputStream is=ActionMapper.class.getClassLoader().getResourceAsStream("framework.xml");
		Document document = new SAXReader().read(is);
		Element root = document.getRootElement();
		//����action�ڵ�
		List<Element> actions=root.elements();
		for(Element element:actions){
			Action action = new Action();
			//��ȡaction������ֵ
			action.setName(element.attributeValue("name"));
			action.setClasses(element.attributeValue("class"));
			String method=element.attributeValue("method");
			if(method!=null)
				action.setMethod(method);
			//����Action�еĽ����
			List<Element> results = element.elements();
			for(Element e:results){
				Result result = new Result();
				String resultName = e.attributeValue("name");
				String resultType = e.attributeValue("type");
				if(resultName!=null)
					result.setName(resultName);
				if(resultType!=null)
					result.setType(resultType);
				result.setLocation(e.getStringValue());
				//��Result������ӵ�Action��
				action.getResultMap().put(result.getName(), result);
			}
			//��Action���뵽actionMap��
			actionMap.put(action.getName(), action);
		}
	}
}
