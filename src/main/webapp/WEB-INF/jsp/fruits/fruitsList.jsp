<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
           
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>水果列表</title>
</head>
<body>
<h3>商品详情</h3>
<table width="300px;" border=1>
<tr>
<td>名称</td>
<td>价格</td>
<td>产地</td>
</tr>
<c:forEach items="${fruitsList}" var="fruit">
<tr>
<td>${fruit.name}</td>
<td>${fruit.price}</td>
<td>${fruit.producing_area}</td>
</tr>
</c:forEach>
</table>
</body>
</html>