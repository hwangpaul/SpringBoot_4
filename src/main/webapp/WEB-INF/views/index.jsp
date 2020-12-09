<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/bootStrap.jsp"></c:import>
<link href="./css/index.css" rel="stylesgeet">
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
  
<div class="container">
  <h3>V2</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  
  <h1>Message : <spring:message code="hello"></spring:message> </h1>
  <img alt="" src="./images/image_1.png">
</div>
</body>
</html>