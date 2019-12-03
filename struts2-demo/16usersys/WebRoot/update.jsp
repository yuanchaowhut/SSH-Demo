<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    <form action="update.action" method="post">
    <input type="hidden" name="user.id" value="<s:property value="user.id"/>"/>
    	用户名:<input type="text" name="user.name" value="<s:property value="user.name"/>"/><br>
    	密码:<input type="password" name="user.pwd" value="<s:property value="user.pwd"/>"/><br>
    	会员等级:<select name="user.vipId">
    		<s:iterator value="map">
    			<option <s:if test="user.vipId==key">selected</s:if> value="<s:property value="key"/>"><s:property value="value"/></option>
    		</s:iterator>
    	</select><br>
    	<input type="submit" value="修改"/>
    </form>
  </body>
</html>
