<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="add.action" method="post">
    	用户名:<input type="text" name="name"/><br>
    	爱好:<input type="checkbox" name="hobbies" value="football"/>足球
    	<input type="checkbox" name="hobbies" value="basketball"/>蓝球
    	<input type="checkbox" name="hobbies" value="pingpang"/>乒乓球
    	<input type="checkbox" name="hobbies" value="yumaoqiu"/>羽毛球<br>
    	喜欢游戏:<input type="checkbox" name="games" value="lol"/>英雄联盟
    	<input type="checkbox" name="games" value="dota"/>dota
    	<input type="checkbox" name="games" value="war3"/>魔兽争霸
    	<input type="checkbox" name="games" value="cs"/>反恐精英<br>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
