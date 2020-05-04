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
	</div>
	<form action="${pageContext.request.contextPath }/editCategorySubmit.action" method="post">
		<input type="hidden" name="id" value="${category.id }"/>
		<table align="center"  border=2>
			<tr>
				<td>类别名称：</td>
				<td><input type="text" name="name" value="${category.name }"></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="description" value="${category.description }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="确认修改"/>
			</tr>
		</table>
	</form>
</body>
</html>