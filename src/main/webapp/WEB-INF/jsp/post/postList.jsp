<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<title>메모글 리스트</title>
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="d-flex justify-content-center">
			<div class="w-75 text-center my-5">
				<h1 class="text-center">메모 리스트</h1>
				<table class="table mt-3">
					<thead>
						<tr>
							<th>No.</th>
							<th>제목</th>
							<th>시간</th>	
						</tr>
					</thead>
					<tbody>
						
						<%-- 반복 시작 --%>
						<c:forEach var="postlist" items="${postList }" varStatus="status">
							<tr>
								<td>${postlist.id }</td>
								<td>
									<a href="/post/listContentView?postId=${postlist.id }" class="text-dark">
										<c:set var="titleLength" value="${postlist.subject }"/>
										<c:choose>
										
											<c:when test="${fn:length(titleLength) gt 15}">
												${fn:substring(titleLength,0,15) }..
											</c:when>
											<c:otherwise>
												${postlist.subject }
											</c:otherwise>
										</c:choose>
									</a>
								</td>
								<td><fmt:formatDate value="${postlist.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
						<%-- 반복 끝 --%>
					</tbody>
				
				
				
				
				
				
				</table>
				
				<div class="d-flex justify-content-end m-3">
					<a href="/post/postView" class="btn btn-info">글쓰기</a>
				</div>
			
			</div>
		
		
		</section>
		
		
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>


</body>
</html>