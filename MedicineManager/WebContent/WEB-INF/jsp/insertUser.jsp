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
<title>添加用户</title>
</head>
<c:if test="${error != null }">
	<c:forEach items="${error }" var="error">
		${error.defaultMessage }
	</c:forEach>
</c:if>
<body>
	<form action="${pageContext.request.contextPath }/user/insertUser.action" method="post">
		<table align="center"  border=2>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="添加"/>
			</tr>
		</table>
	</form>
</body>
</html>