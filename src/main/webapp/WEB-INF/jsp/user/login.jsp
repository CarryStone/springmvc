<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
<form action="login.action" method="post">
用户名：<input type="text" name="username"/>
密码：<input type="password" name="password"/>
<input type="submit" value="确定"/>
<br/>
<c:if test="${errorList!=null}">
  <c:forEach items="${errorList}" var="err">
    <font color="red">${err.defaultMessage }</font>
  </c:forEach>
</c:if>

<c:if test="${errorMessage!=null}">
    <font color="red">${errorMessage}</font>
</c:if>
</form>
</body>
</html>