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
	<form  action="${pageContext.request.contextPath }/category/deleteManyCategory.action" method="post">
		类别列表：
		<table border=1>
		<tr>
			<td>选择</td>
			<td>类别名称</td>
			<td>描述</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${categoryList }" var="category">
		<tr>
			<td><input type="checkbox" name="category_id" value="${category.id}"/></td>
			<td>${category.name }</td>
			<td>${category.description }</td>
			<td><a href="${pageContext.request.contextPath }/category/editCategory.action?id=${category.id}">修改</a></td>
			<td><a href="${pageContext.request.contextPath }/category/deleteCategory.action?id=${category.id}">删除</a></td>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="删除所选"/>
		<a href="${pageContext.request.contextPath }/medicine/home.action">返回主界面</a>
	</form>
</body>
</html>