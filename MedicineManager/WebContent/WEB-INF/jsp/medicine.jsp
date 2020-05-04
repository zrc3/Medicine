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

<script type="text/javascript">
	function queryMedicine(){
		//提交form
		document.medicineForm.action="${pageContext.request.contextPath }/medicine/queryMedicine.action";
		document.medicineForm.submit();
	}
</script>
<body>
	<form name="medicineForm" action="${pageContext.request.contextPath }/medicine/deleteManyMedicine.action" method="post">
		
			<table width="100%" border=1>
				<tr>
					<td>商品名称:<input name="name">
					</td>
		
					<td>
					<input type="button" value="查询" onclick="queryMedicine()"/>
					</td>
				</tr>
			</table>
		
		药品列表：
		<table width="100%" border=1>
		<tr>
			<td>选择</td>
			<td>编号</td>
			<td>药品名称</td>
			<td>生产厂家</td>
			<td>所属类别</td>
			<td>描述</td>
			<td>价格</td>
			<td>药品总共数量</td>
			<td>照片</td>
			<td colspan="3">操作</td>
		</tr>
		<c:forEach items="${medicineList }" var="medicine">
		<tr>
			<td><input type="checkbox" name="medicine_id" value="${medicine.id}"/></td>
			<td>${medicine.medno }</td>
			<td>${medicine.name }</td>
			<td>${medicine.factoryadd }</td>
			<td>${medicine.category.name }</td>
			<td>${medicine.description }</td>
			<td>${medicine.price }元</td>
			<td>${medicine.medcount }</td>
			<td>
				<c:if test="${medicine.photo !=null}">
					<img src="/pic/${medicine.photo}" width=100 height=100/>
					<br/>
				</c:if>
				<!-- <input type="file"  name="med_pic"/>  -->
			</td>
			<c:if test="${username!='admin' }">
				<td><a href="${pageContext.request.contextPath }/medicine/buyMedicine.action?id=${medicine.id}">购买</a></td>
			</c:if>
			<c:if test="${username=='admin' }">
				<td><a href="${pageContext.request.contextPath }/medicine/goodsMedicine.action?id=${medicine.id}&medcount=${medicine.medcount}">进货</a></td>
				<td><a href="${pageContext.request.contextPath }/medicine/editMedicine.action?id=${medicine.id}">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/medicine/deleteMedicine.action?id=${medicine.id}?">删除</a></td>
			</c:if>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="删除所选"/>
		<a href="${pageContext.request.contextPath }/medicine/home.action">返回主界面</a>
	</form>
</body>
