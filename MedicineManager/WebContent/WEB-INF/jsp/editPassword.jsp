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

<body>
	<div align="center">
		<c:if test="${error != null }">
			<c:forEach items="${error }" var="error">
				${error.defaultMessage }
			</c:forEach>
		</c:if>
		<c:if test="${otherError != null }">
			${otherError }
		</c:if>
	</div>
	<form action="${pageContext.request.contextPath }/user/editPasswordSubmit.action" method="post">
		<table align="center"  border=2>
			<tr>
				<td>新密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>重复新密码：</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="确认修改"/>
			</tr>
		</table>
	</form>
</body>
</html>