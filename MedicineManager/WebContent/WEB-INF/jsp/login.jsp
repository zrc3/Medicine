<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    <%
    	String basePath=request.getScheme()+"://"+
    	request.getServerName()+":"+
    	request.getServerPort()+	
    	request.getContextPath()+"/";
     %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title>登陆界面</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div id="login">
		<h1>用户登录</h1>	
		<form action="${pageContext.request.contextPath }/login.action" method="post">
			<p><input type="text" name="username" id="user" placeholder="用户名"></p>
			<p><input type="password" name="password" id="pwd" placeholder="密码"></p>
			<p><input type="submit" id="submit" value="登录"></p>
			<p><input type="reset" id="reset" value="重置"></p>
		</form>
	</div>
	<!-- <div style="text-align:center;">
		<p>更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
	</div> -->
</body>
</html>