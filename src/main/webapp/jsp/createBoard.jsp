<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

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

<script>

$(function(){
	//페이지 로딩시 select box 설정
// 	$("select[name=active]").val("${active}").prop("selected", true);
	
	//select box 변경 이벤트
// 	$("select[name=isYn]").change(function(){
// 		$("form").submit();
// 	});
});

</script>

</head>

<body>

	<!-- top.jsp -->
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="blog-header">
					<h1 class="form-signin-heading">게시판 추가</h1>
				</div>

				<div class="row">

					<form name="frmCreate" class="form-horizontal" action="/boardCreate" method="post" role="form">
						<div class="col-sm-10 blog-main">
							<label class="col-sm-3 control-label">게시판 이름</label> 
							<input type="hidden" name="boardId" value="0">
							<input type="text" id="boardName" name="boardName" class="form" placeholder="게시판 이름" required autofocus> 
							<select id="isYn" name="isYn">
								<option value="Y">사용</option>
								<option value="N">미사용</option>
							</select>
							<button class="btn btn-primary" type="submit">게시판 개설</button>
						</div>
					</form>
					
					<br><br>
					
					<div class="blog-header">
						<h2 class="form-signin-heading">게시판 수정</h2>
					</div>
					
					<c:if test="${fn:length(boardList) < 1}">
						<h5>아직 개설된 게시판이 없습니다.</h5>
					</c:if>

					<c:forEach items="${boardList }" var="boardList">
						<form name="boardUpdate" class="form-horizontal" action="/boardCreate" method="post" role="form">
							<div class="col-sm-10 blog-main">
								<label class="col-sm-3 control-label">게시판 이름</label> 
								<input type="hidden" name="boardId" value="${boardList.id }">
								<input type="text" id="boardName" name="boardName" class="form" value="${boardList.name }" required autofocus> 
								<select id="isYn" name="isYn">
									<option value="Y" ${boardList.active eq 'Y'  ? "selected" : ''}>사용</option>
									<option value="N" ${boardList.active eq 'N'  ? "selected" : ''}>미사용</option>
								</select>
								<button class="btn btn-primary" type="submit">수정</button>
							</div>
							<br><br>
						</form>
					</c:forEach>
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
