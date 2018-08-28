<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add book</title>
</head>
<body>

	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

	<h1>register user</h1>
	<div>
		<form action="<%=basePath%>book/addbook" method="post" enctype="multipart/form-data">
		   <p>UserPicture: <input type="file" id="uploadFile" name="uploadFile" /></p>
		   <p><input type="submit" value="提交"></p>
		</form>
	</div>


<p><a href="<%=basePath%>book/index">index</a></p>

</body>
</html>