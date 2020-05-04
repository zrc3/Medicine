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
	<form  action="${pageContext.request.contextPath }/medicine/goods.action" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<input type="hidden" name="curCount" value="${medCount }"/>
		<table border=1>
		<tr>
			<td>需要进多少药</td>
			<td><input type="text" name="medCount"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="确认进货" ></td>
		</tr>
		</table>
	</form>
</body>
</html>