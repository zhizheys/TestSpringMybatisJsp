<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	
	<h1>the login page</h1>
	
	<div>
		<form action="${pageContext.request.contextPath}/login/login" method="post">
		   <p>UserName: <input type="text" id="userName" name="userName"></p>
		   <p>UserPassword: <input type="text" id="userPassword" name="userPassword"></p>
		   <p><input type="submit" vaule="登录"></p>
		</form>
	</div>
</body>
</html>