<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
		
		<div>
		   <c:if test = "${allErrors.size() > 0}">
		      	<h1>all errors</h1>
		      	<table>
		      		<tbody>
		      			<c:forEach  var="student" items="${ allErrors}" varStatus="status">
				      	   <tr>  
							    <td>${ status.index + 1}</td>  
							    <td>${ student.getDefaultMessage()}</td>
							</tr> 
					    </c:forEach >
		      		</tbody>
		      	</table>
		      
		   </c:if>
		
			
			
		</div>
	</div>
	


<p><a href="<%=basePath%>book/index">index</a></p>

</body>
</html>