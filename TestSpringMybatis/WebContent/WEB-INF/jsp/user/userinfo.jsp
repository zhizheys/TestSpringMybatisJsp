<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
    <input type="text" id="urlBase" name="urlBase" value="${ctx}"/>
    
    <div>
       <h2>ajax add user info</h2>
    	<h3 style="color:blue;" id="userIdDiv" name="userIdDiv""></h3>
    	
       <p>-------------------------------</p>
   	   <p>UserName: <input type="text" id="userName" name="userName"></p>
	   <p>UserAge: <input type="text" id="userAge" name="userAge"></p>
	   <p>UserAddress: <input type="text" id="userAddress" name="userAddress"></p>
	   <p>UserPassword: <input type="text" id="userPassword" name="userPassword"></p>
	   <p>UserBirthday: <input type="text" id="userBirthday" name="userBirthday"></p>
   	   <p><input type="button" id="btnAddUser" name="btnAddUser" value="add user" />
    </div>
    
    <p>====================================================================</p>
    <div>
    	<h2>ajax get user info</h2>
    	<h3 style="color:red;" id="userInfoDiv" name="userInfoDiv"></h3>
    	<p>-------------------------------</p>
    	<p>userId: <input type="text" id="userId" name="userName" />
    	<p><input type="button" id="btnSubmit" name="btnSubmit" value="get user by Id" />
    </div>
    
    <script src="${ctx}/static/js/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/app/user.js" type="text/javascript"></script>
</body>
</html>