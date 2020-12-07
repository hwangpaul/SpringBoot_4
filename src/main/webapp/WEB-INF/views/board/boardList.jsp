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
  <h3>${board} List Page V1</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  
 	<img alt="" src="../images/image_1.png">
	
   	<div class="list_con">
   	
	  <!-- search -->
	  <form action="./${board}List" id="frm">
	  <input type="hidden" name="curPage" id="curPage" value=1>
	  
	<div class="form-group">
	  <label for="sel1">Select list:</label>
	  <select class="form-control" id="kind" name="kind">
  		  <option>title</option>
  		  <option>writer</option>
  		  <option>contents</option>
    
	  </select> 
  </div>
	 <div class="input-group">
    	<input type="text" class="form-control" placeholder="Search" name="search" id="search">
  		  <div class="input-group-btn">
    	  <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
	  	</form>
	  	<!-- search -->
	  	
	  
	  
	  
			<table class="table table-hober">
				<tr>
					<td>Num</td>
					<td>Title</td>
					<td>Writer</td>
					<td>Contents</td>
					<td>Date</td>
					<td>Hit</td>
					
				</tr>
				
				<c:forEach items="${lists}" var="vo">
					<tr>
						<td>${vo.num}</td>
						<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.contents}</td>
						<td>${vo.regDate}</td>
						<td>${vo.hit}</td>
					
					</tr>
				</c:forEach>
			</table>
`			<!-- Page -->

			<ul class="pagination">
			<c:if test="${pager.before}">
				<li><a href="#" class="list" title="${pager.startNum-1}">Before</a></li>
			</c:if>						
 			 <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
 				<li><a href="#" class="list" title="${i}">${i}</a></li>
 			</c:forEach>	
 			<c:if test="${pager.after}">
				<li><a href="#" class="list" title="${pager.lastNum+1}">After</a></li>
			</c:if>		
			</ul>
			<!-- Page -->
	
		
	  </div>
	  	<!-- Write 버튼 생성 클릭 -->
  		<button id="btn">Write</button><!-- Form 태그내에서는 Submit event가 실행 -->
  		<input type="submit" value="Write" ><!-- Form 태그내에서는 Submit event가 실행 -->
  		<input type="button" value="Write" ><!-- 그냥 버튼 -->
	 
	</div>  
	  
  
	
</body>
<script type="text/javascript">
	//$(document).ready(function(){  // HTML 문서가 로딩이 끝났을 때

	//$(function(){					 // document.ready의 축약형
	
		$("#search").val('${param.search}');

		var kind = '${param.kind}';
		if(kind != ''){
			$("#kind").val(kind);
			}
		
	
		$(".list").click(function(){
			var curPage = $(this).attr("title");
			$("#curPage").val(curPage);
	
			$("#frm").submit();
			

		});
	
		$("#btn").click(function(){
			location.href = "./${board}Write";

		});
		

		

</script>

</html>
