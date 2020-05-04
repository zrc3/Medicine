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
<title>修改药品信息</title>
</head>

<body>
	<c:if test="${error!=null }">
		<c:forEach items="${error }" var="error">
			${error.defaultMessage},
		</c:forEach>
	</c:if>
	<form id="itemForm" action="${pageContext.request.contextPath }/medicine/editMedicineSubmit.action" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${medicine.id }"/>
		修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>药品编号</td>
				<td><input type="text" name="medno" value="${medicine.medno }"/></td>
			</tr>
			<tr>
				<td>药品名称</td>
				<td><input type="text" name="name" value="${medicine.name }"/></td>
			</tr>
			<tr>
				<td>生产厂家</td>
				<td><input type="text" name="factoryadd" value="${medicine.factoryadd}"/></td>
			</tr>
			<tr>
				<td>所属类别</td>
				<td>
					<c:if test="${medicine.categoryid==1}">
						<input type="text" name="category1" value="感冒用药">
					</c:if>
					<c:if test="${medicine.categoryid==2}">
						<input type="text" name="category1" value="胃肠用药">
					</c:if>
				</td>
			</tr>
			<tr>
				<td>药品描述</td>
				<td>
				<textarea rows="3" cols="30" name="description">${medicine.description }</textarea>
				</td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price" value="${medicine.price }">元</td>
			</tr>
			<tr>
				<td>药品总共数量</td>
				<td><input type="text" name="medcount" value="${medicine.medcount }"></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${medicine.photo !=null}">
						<img src="/pic/${medicine.photo}" width=100 height=100/>
						<br/>
					</c:if>
					<input type="file"  name="med_pic"/> 
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"/>
			</tr>
		</table>
	
	</form>
</body>
</html>