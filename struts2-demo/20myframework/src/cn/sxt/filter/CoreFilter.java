package cn.sxt.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import cn.sxt.core.Action;
import cn.sxt.core.ActionMapper;
import cn.sxt.core.Result;

public class CoreFilter implements Filter{
	public void destroy() {
	}
	public void init(FilterConfig config) throws ServletException {
		try {
			//程序启动后 解析配置文件  
			ActionMapper.parser();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doFilter(ServletRequest rq, ServletResponse rp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)rq;
		HttpServletResponse resp = (HttpServletResponse)rp;
		
		//将请求映射到action上
		Action targetAction=reqToAction(req);
		if(targetAction==null)
			chain.doFilter(rq, rp);
		//创建action对象
		try {
			Object proxyAction=createProxyAction(targetAction.getClasses());
			//将用户提交的数据设置到action的属性上
			setProperty(req,proxyAction);
			//执行action的方法
			String result=execute(proxyAction,targetAction.getMethod());
			//处理结果
			//获取结果对象
			Result r=targetAction.getResultMap().get(result);
			resultExecute(req,resp,r,proxyAction);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//将请求映射到action上
	private Action reqToAction(HttpServletRequest req){
		String path=req.getRequestURI();
		//只处理以action结尾的请求
		if(!path.endsWith(".action"))
			return null;
		//获得请求名
		String reqName=path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("."));
		return ActionMapper.actionMap.get(reqName);
	}
	//创建action对象
	private Object createProxyAction(String className) throws Exception{
		Class clzz = Class.forName(className);
		return clzz.newInstance();
	}
	//将用户提交的数据设置到action的属性上---简化很多
	private void setProperty(HttpServletRequest req,Object obj) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		//创建Class
		Class clzz=obj.getClass();
		Map map=req.getParameterMap();
		for(Iterator iter = map.keySet().iterator();iter.hasNext();){
			Object key=iter.next();
			//根据提交参数 去找 Field
			Field field = clzz.getDeclaredField(key.toString());
			if(field==null){
				continue;
			}
			field.setAccessible(true);
			//要进行相应的类型转换---省略了
			field.set(obj, req.getParameter(key.toString()));
			field.setAccessible(false);
		}
	}
	//执行action的方法
	private String execute(Object proxyAction, String method) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class clzz = proxyAction.getClass();
		Method m=clzz.getDeclaredMethod(method);
		return (String)m.invoke(proxyAction);
	}
	//处理结果
	private void resultExecute(HttpServletRequest req,
			HttpServletResponse resp, Result r, Object proxyAction) throws IOException, IllegalArgumentException, IllegalAccessException, ServletException {
		if("redirect".equals(r.getType())){
			resp.sendRedirect(r.getLocation());
			return;
		}
		//将action的属性值 设置到req的attribute中
		Class clzz = proxyAction.getClass();
		Field[] fds = clzz.getDeclaredFields();
		for(Field fd:fds){
			fd.setAccessible(true);
			req.setAttribute(fd.getName(), fd.get(proxyAction));
			fd.setAccessible(false);
		}
		req.getRequestDispatcher(r.getLocation()).forward(req, resp);
	}
}
