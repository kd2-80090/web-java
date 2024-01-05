<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rg" class="com.sunbeam.beans.RegistrationBean"></jsp:useBean>
<jsp:setProperty  name="rg"  property="*" />

${ rg.saveUser() }


<c:choose>
		<c:when test="${rg.getStatus() == 'true'}">
Registration Status :<jsp:getProperty name="rg" property="status" /><br><br>
			<a href="index.jsp">Login</a>	
		</c:when>
		<c:when test="${lb.user.role == 'false'}">
Registration Status :<jsp:getProperty name="rg" property="status" /><br><br>
			<a href="registrationform.jsp">	Register again</a>	
		</c:when>
	</c:choose>


</body>
</html>