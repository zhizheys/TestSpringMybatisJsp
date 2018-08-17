<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register user</title>
</head>
<body>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

	<h1>register user</h1>
	<div>
		<form action="<%=basePath%>user/adduser" method="post">
		   <p>UserName: <input type="text" id="userName" name="userName"></p>
		   <p>UserAge: <input type="text" id="userAge" name="userAge"></p>
		   <p>UserAddress: <input type="text" id="userAddress" name="userAddress"></p>
		   <p>UserPassword: <input type="text" id="userPassword" name="userPassword"></p>
		   <p>UserBirthday: <input type="text" id="userBirthday" name="userBirthday"></p>
		   <p><input type="submit" vaule="提交"></p>
		</form>
	</div>
	
</body>
</html>