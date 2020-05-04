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
	<form name="medicineForm" action="${pageContext.request.contextPath }/medicine/deleteManyMedicine.action" method="post">
		已购买药品：
		<table width="100%" border=1>
		<tr>
			<td>药品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>金额</td>
			<!-- <td colspan="3">操作</td> -->
		</tr>
		<c:forEach items="${orderList }" var="order">
		<tr>
			<td>${order.name }</td>
			<td>${order.price }元</td>
			<td>${order.count }</td>
			<td>${order.total }</td>
		</tr>
		</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/medicine/home.action">返回主界面</a>
	</form>
</body>
