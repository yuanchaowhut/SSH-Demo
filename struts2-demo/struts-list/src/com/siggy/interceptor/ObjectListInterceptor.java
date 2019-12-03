package com.siggy.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * String数组 到List泛型 对象
 * @author siggy
 * @version v1.0 2012-08-21
 * */
public class ObjectListInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(ObjectListInterceptor.class);

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (LOG.isInfoEnabled()) {
			LOG.info("invoke ObjectListInterceptor ... ");
		}
		Object action = invocation.getProxy().getAction();	
		Map<String, Class<?>> objectListFieldMap = new HashMap<String, Class<?>>();
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ac = invocation.getInvocationContext();
		// set  final Map parameters = ac.getParameters();
		setFieldMap(action,objectListFieldMap);
		//如果有List类型的属性--执行if，如果没有不执行该拦截器
		if (objectListFieldMap.size() != 0) {
			for (Iterator<Entry<String, Class<?>>> it = objectListFieldMap
					.entrySet().iterator(); it.hasNext();) {
				Entry<String, Class<?>> entry = it.next();
				//获取 List属性名
				String name = entry.getKey();
				//获取List的泛型类型
				Class<?> Clazz = entry.getValue();
				Map<String, String[]> paramAndValues = new HashMap<String, String[]>();
				//批量提交 的集合个数
				int size = setObjectListParam(request, name, paramAndValues);
				if(size>0){
					Object[] object = createObject(paramAndValues, size, Clazz);
					if (LOG.isInfoEnabled()) {
						LOG.info("the " + name + "'s value is" + object
								+ " in action [" + action + "]");
					}
					ValueStack stack = ac.getValueStack();
					stack.setValue(name, object);
				}
			}
		}
		return invocation.invoke();
	}
	@SuppressWarnings("unchecked")
	private void setFieldMap(Object action,Map objectListFieldMap){
		final Field[] fields = action.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAccessible() == false) {
				field.setAccessible(true);
				if (field.getType().isAssignableFrom(List.class)) {
					objectListFieldMap.put(field.getName(), getActualType(field));
				}
				field.setAccessible(false);
			}else{
				if (field.getType().isAssignableFrom(List.class)) {
					objectListFieldMap.put(field.getName(), getActualType(field));
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	private Class<?> getActualType(Field field){
		Type type = field.getGenericType(); // 关键的地方，如果是List类型，得到其Generic的类型
		if (type instanceof ParameterizedType) // 如果是泛型参数的类型
		{
			ParameterizedType pt = (ParameterizedType) type;
			Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];
			// 得到泛型里的class类型对象。
			return genericClazz;
		}
		return Object.class;
	}
	@SuppressWarnings("unchecked")
	private int setObjectListParam(HttpServletRequest request, String name,
			Map<String, String[]> paramAndValues) {

		int size = -1;
		for (Enumeration<String> parameterNames = request.getParameterNames(); parameterNames
				.hasMoreElements();) {
			String parameterName = parameterNames.nextElement();
			if (parameterName.startsWith(name + ".")) {
				String[] values = request.getParameterValues(parameterName);
				if (values != null && values.length > 0) {
					paramAndValues.put(parameterName
							.substring(name.length() + 1), values);
					if (values.length>size) {
						size = values.length;
					}
				}
			}
		}
		return size;
	}

	private Object[] createObject(final Map<String, String[]> paramAndValues,
			int size, Class<?> clazz) throws InstantiationException,
			IllegalAccessException {
		//创建批量提交对象数组
		Object[] result = new Object[size];
		for (int i = 0; i < result.length; i++) {
			//为指定数组元素赋值
			result[i] = clazz.newInstance();;
		}
		for (Iterator<Entry<String, String[]>> it = paramAndValues.entrySet()
				.iterator(); it.hasNext();) {
			Entry<String, String[]> entry = it.next();
			String name = (String) entry.getKey();
			String[] values = entry.getValue();
			for (int i = 0; i < result.length; i++) {
				Object object = result[i];
				//if(i>values.length-1)
					setValue(object, name, values[i]);
//				else
//					setValue(object, name, null);
			}
		}
		return result;
	}

	private void setValue(Object object, String name, String value) {
		try {
			Field field = object.getClass().getDeclaredField(name);
			boolean isFoolback = false;
			if (field.isAccessible() == false) {
				isFoolback = true;
				field.setAccessible(true);
			}
			if (field.getType() == int.class) {
				field.setInt(object, Integer.parseInt(value));
			} else if (field.getType() == long.class) {
				field.setLong(object, Long.parseLong(value));
			} else if (field.getType() == float.class) {
				field.setFloat(object, Float.parseFloat(value));
			} else if (field.getType() == double.class) {
				field.setDouble(object, Double.parseDouble(value));
			} else if (field.getType() == short.class) {
				field.setShort(object, Short.parseShort(value));
			} else if (field.getType() == byte.class) {
				field.setByte(object, Byte.parseByte(value));
			} else if (field.getType() == boolean.class) {
				field.setBoolean(object, Boolean.parseBoolean(value));
			} else {
				field.set(object, value);// String
			}
			if (isFoolback) {
				field.setAccessible(false);
			}
		} catch (Exception e) {
		}
	}

}
