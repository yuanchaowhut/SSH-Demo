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
  <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$('#btn').click(function(){
  			$.post("json.action",function(data){
  				var html="";
  				for(var i=0;i<data.length;i++){
  					html+="<tr><td>"+data[i].name+"</td><td>"+data[i].age+"</td></tr>";
  				}
  				$('#content').html(html);
  			},'json');
  		});
  	});
  </script>
  </head>
  
  <body>
    <input type="button" id="btn" value="获取json数据"/>
   <table width="80%" align="center">
   	<tr>
   		<td>姓名</td>
   		<td>年龄</td>
   	</tr>
   	<tbody id="content">
   	</tbody>
   </table>
  </body>
</html>
