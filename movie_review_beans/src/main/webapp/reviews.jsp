<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-4">
    <h2>Hello ${lb.user.firstName} ${lb.user.lastName}</h2>
    
    <a href='reviews.jsp?type=allreviews'>All Reviews</a>
    <a href='reviews.jsp?type=myreviews'>My Review</a>
    <a href='reviews.jsp?type=sharedreviews'>Shared Review</a><br/>
    
    <jsp:useBean id="rb" class="com.sunbeam.beans.ReviewListBean" />
    <jsp:setProperty name="rb" property="currUser" value="${lb.user.id}" />
    <jsp:setProperty name="rb" property="type" param="type"/>
    
    ${rb.fetchReviews()}
    
    <h3>${rb.reviewTitle}</h3>
    
    <div class="table-responsive">
      <table class="table table-bordered table-primary">
        <thead class="thead-dark">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Movie</th>
            <th scope="col">Rating</th>
            <th scope="col">Review</th>
            <th scope="col">User Id</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="c" items="${rb.reviewList}">
            <tr>
              <td>${c.id}</td>
              <td>${c.movie_id}</td>
              <td>${c.rating}</td>
              <td>${c.review}</td>
              <td>${c.user_id}</td>
              
              <c:if test="${lb.user.id == c.user_id}">
                <td>
                  <a href='editreview.jsp?reviewid=${c.id}'><img src='images/edit.png' width='24' height='24' alt='Edit'></a>
                  <a href='deletereview.jsp?reviewid=${c.id}&userid=${c.user_id}'><img src='images/delete.png' width='24' height='24' alt='Delete'></a>
                  <a href='sharereview.jsp?reviewid=${c.id}'><img src='images/share.png' width='24' height='24' alt='Share'></a>
                </td>
              </c:if>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
