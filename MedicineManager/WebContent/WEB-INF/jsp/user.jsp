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
<title>用户信息</title>
</head>
<body>
	<form name="medicineForm" action="${pageContext.request.contextPath }/user/deleteManyUser.action" method="post">
		用户列表：
		<table border=1>
		<tr>
			<td>选择</td>
			<td>用户名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList }" var="user">
		<tr>
			<td><input type="checkbox" name="user_id" value="${user.id}"/></td>
			<td>${user.username }</td>
			<td><a href="${pageContext.request.contextPath }/user/deleteUser.action?id=${user.id}">删除</a></td>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="删除所选"/>
	</form>
</body>
</html>