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
<title>药品信息</title>
</head>

<body>
	<form name="sellForm" action="${pageContext.request.contextPath }/medicine/deleteManyMedicine.action" method="post">
		销售列表：
		<table width="100%" border=1>
		<tr>
			<td>药品名称</td>
			<td>单价</td>
			<td>销售数量</td>
			<td>销售总价</td>
		</tr>
		<c:forEach items="${sellList }" var="sell">
		<tr>
			<td>${sell.name }</td>
			<td>${sell.sellprice }</td>
			<td>${sell.sellcount }</td>
			<td>${sell.sellallmoney }</td>
		</tr>
		</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/medicine/home.action">返回主界面</a>
	</form>
</body>
