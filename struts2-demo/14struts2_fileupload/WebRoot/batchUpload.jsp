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
	 <style type="text/css">
	 p{margin:5px;}
	 </style>
	  <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	  <script type="text/javascript">
	  	$(function(){
		  	$('#btn').click(function(){
		  		var field="<p><input type='file' name='file'/><input type='button' value='删除' onclick='removed(this);'/></p>";
		  		$('#files').append(field);
		  	
		  	});
	  	});
	  	function removed(o){
	  		$(o).parent().remove();
	  	}
	  </script>
  
  </head>
  
  <body>
    	<form action="batch.action" method="post" enctype="multipart/form-data">
    		文件:<input type="file" name="file"/><input type="button" id="btn" value="添加"/>
    		<div id="files"></div>
    		<input type="submit" value="上传"/>
    	</form>
  </body>
</html>
