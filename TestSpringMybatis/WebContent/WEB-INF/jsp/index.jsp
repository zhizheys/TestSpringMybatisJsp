<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>the jsp index page</h1>
	<h1>首页</h1>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	
	
	<p><a href="<%=basePath%>user/show">to show one user</a></p>
	<p><a href="<%=basePath%>user/showalluser">all user</a></p>
	<p><a href="<%=basePath%>user/registeruser">add user</a></p>
	<p><a href="<%=basePath%>user/dealuser">deal user</a></p>
	<p><a href="<%=basePath%>book/test">test error</a></p>
	
	<p><a href="<%=basePath%>login/logout"><h1>logout</h1></a></p>
</body>
</html>