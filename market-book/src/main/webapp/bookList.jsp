
<%@page import="org.apache.jasper.JasperException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Book Lists</h1>
    <ul>
        <c:forEach var="book" items="${books}">
        <li>${book.getBookTitle()}<li>
        </c:forEach>
    </ul>
</body>
</html>
