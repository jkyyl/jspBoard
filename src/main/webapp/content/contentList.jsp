<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.student.service.StudentService"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click", function(){
			//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
			$("#id").val($(this).data("id"));
			//form 태그를 submit
			$("#frm").submit();
			console.log("table tbody tr clicked : " + $(this).data("id"));
		});
		
// 		$("#newContentBtn").on("click", function(){
// 			location.href="/";
// 		});
	});
</script>

</head>

<body>

	<%@include file="/common/top.jsp" %>
	
	<form id="frm" action="/contentDetail" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<c:set value="${selectedBoard }" var="selectedBoard"/>
						<c:set value="${contentList }" var="contentList"/>
						
						<div>
							<h2 class="form-signin-heading">${selectedBoard.name }</h2>
						</div>
						
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>게시글 번호</th>
										<th>게시글 제목</th>
										<th>작성자</th>
										<th>작성일시</th>
										<th>조회수</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${contentList}" var="contentList">
									<%-- tr 태그 클릭시 상세 페이지로 이동 --%>
										<c:choose>
											<c:when test="${contentList.active eq 'Y' }">
										<tr data-id="${contentList.no }" >
												<td>${contentList.no}</td>
												<td>${contentList.title}</td>
												<td>${contentList.writer}</td>
												<td><fmt:formatDate value="${contentList.regDt }" pattern="yyyy-MM-dd" /></td>
	<%-- 											<td>${contentList.regDt }</td> --%>
												<td>${contentList.viewCnt}</td>
										</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td onclick='event.cancelBubble=true;' colspan="5">삭제된 글입니다.</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<a name="newContentBtn" href="/contentCreate" class="btn btn-default pull-right">새글 쓰기</a>

<%-- 						<input type="hidden" value="${board_id }" name="board_id"/> --%>
						
						<div class="text-center">
							<ul class="pagination">
								<%=session.getAttribute("pageNavi") %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>