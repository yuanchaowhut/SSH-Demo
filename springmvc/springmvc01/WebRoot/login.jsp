<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

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
	<form action="user.do" method="post">
		用户名:<input type="text" name="name"  value="${user.name}"/> <br> 
		年    龄:<input type="text" name="age"  value="${user.age}" /> <br> 
		手机号:<input type="text" name="tel"  value="${user.tel}" /> <br> 
		<input type="hidden" name="method" value="login" /> <br>
		<input	type="submit" value="登录" />
	</form>
</body>
</html>
