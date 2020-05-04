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
<title>药店管理系统</title>
</head>
<body>
	欢迎您:${username}<br>
	<a href="${pageContext.request.contextPath }/logout.action">退出</a><br>
	<c:if test="${username == 'admin' }">
		<a href="${pageContext.request.contextPath }/medicine/insert.action">添加药品</a>
		<a href="${pageContext.request.contextPath }/user/insert.action">添加用户</a>
		<a href="${pageContext.request.contextPath }/user/findAllUsers.action">查看所有用户</a>
		<a href="${pageContext.request.contextPath }/category/findCategory.action">查看药品类别</a>
		<a href="${pageContext.request.contextPath }/category/insert.action">添加类别</a>
		<a href="${pageContext.request.contextPath }/sell/findAllSell.action">查看销售情况</a>
	</c:if>
	<c:if test="${username != 'admin' }">
		<a href="${pageContext.request.contextPath }/user/editPassword.action">修改密码</a>
		<a href="${pageContext.request.contextPath }/medicine/already.action?username=${username}">查看已经购买</a>
	</c:if>
		<a href="${pageContext.request.contextPath }/medicine/findAllMedicine.action">查看药品</a>
</body>
</html>