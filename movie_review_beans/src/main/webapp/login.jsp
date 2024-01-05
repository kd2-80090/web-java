<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Validate</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"
		scope="session" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password" />
	<jsp:setProperty name="lb" property="status" value="false" />

	${lb.authenticate()} Login Status :<jsp:getProperty name="lb"
		property="status" /><br>
	<br>


	<c:choose>
		<c:when test="${lb.getStatus() == 'true'}">
			<c:redirect url="reviews.jsp"/>
		</c:when>
		<c:otherwise>
           Invalid Login Credentials.
       <a href="index.jsp">Login again</a>
		</c:otherwise>

	</c:choose>

</body>
</html>