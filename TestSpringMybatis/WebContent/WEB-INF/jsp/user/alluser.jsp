<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>all user</h1>
    
    <table>
    	<thead>
    	 <tr>
    	 	<th>userId</th>
    	 	<th>userName</th>
    	 	<th>userAge</th>
    	 	<th>userAddress</th>
    	 	<th>userPassword</th>
    	 	<th>userBirthday</th>
    	 	<th>IsAudit</th>
    	 	<th>IsAudit2</th>
    	 </tr>
    	</thead>
    	<tbody>
    	   <c:forEach items="${userList}" var="wl">
			    <tr>
		    	    <th>${wl.userId }</th>
		    	    <th>${wl.userName }</th>
		    	    <th>${wl.userAge }</th>
		    	    <th>${wl.userAddress }</th>
		    	    <th>${wl.userPassword }</th>
		    	    <th><fmt:formatDate value="${wl.userBirthday }" var="date" pattern="yyyy-MM-dd"/> ${date}</th>
		    	    <th>
		    	        <c:choose>
						   <c:when test="${wl.userAge > 20}">  
						       Yes   
						   </c:when>
						   <c:otherwise> 
						       No
						   </c:otherwise>
						</c:choose>
		    	    </th>
		    	    
		    	    <th>
					   <c:if test="${wl.userAge > 20}">  
					       Yes   
					   </c:if>
					   <c:if test="${wl.userAge <= 20}">  
					       No
					   </c:if>
		    	    </th>
    	      </tr>
			</c:forEach>

    	</tbody>
    </table>
    
    <%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<p><a href="<%=basePath%>book/index">index</a></p>

</body>
</html>