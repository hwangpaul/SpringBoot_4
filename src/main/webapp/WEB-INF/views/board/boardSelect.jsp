<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
  
<div class="container">
  <h3>${board} Select Page V1</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
   
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${vo.title}">
    </div>
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${vo.writer}">
    </div>
	
	<div class="form-group">
  		<label for="contents">Contents:</label>
 		<textarea class="form-control" rows="5" id="contents" name="contents">${vo.contents}</textarea>
	</div>
	
	<h3>Files</h3>
	<c:forEach items="${vo.files}" var="file">  
	<p><a href="${board}FileDown?fnum=${file.fnum}">${file.oriName}</a></p>
	
  	</c:forEach>  
  
</div>
</body>

</html>