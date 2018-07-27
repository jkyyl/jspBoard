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

// $(function(){
// 	$("#sub").click(function(){
// 		$().
// 	});
	
// });

</script>

</head>

<body>

	<%@ include file="/common/top.jsp" %>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" method="post">
				
				<input type="hidden" id="contentVoNo" name="contentVoNo" value="${contentVo.no }">
				<c:set value="${selectedBoard }" var="selectedBoard"/>
<%-- 				<c:set value="" var=""/> --%>
				
					<div>
						<h2 class="form-signin-heading">${selectedBoard.name }</h2>
					</div>
					
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${contentVo.title }</label>
						</div>
					</div>
				
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${contentVo.content }</label>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcd" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${attachmentList }" var="attachmentList">
								<label class="control-label">${attachmentList.up_name}</label>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
			            	<input id="edit" class="btn btn-primary" type="submit" value="수정" formmethod="get" formaction="/contentUpdate"/>
			            	<input id="del" class="btn btn-primary" type="submit" value="삭제" formaction="/contentDisable"/>
			            	<input id="sub" class="btn btn-primary" type="submit" value="답글" formmethod="get" formaction="/contentCreate"/>
						</div>
					</div>
					
					<input type="hidden" id="replyList" name="replyList" value="${replyList }">
					
					<div class="form-group">
						<label for="reply" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-10">
							<c:forEach items="${replyList }" var="replyList">
								<c:choose>
									<c:when test="${replyList.active eq 'Y' }">
										<label class="control-label">${replyList.content }</label>
										<label class="control-label">[${replyList.std_id} / <fmt:formatDate value="${replyList.reg_dt }" pattern="yyyy-MM-dd" />]
										</label>
										<input type="hidden" name="selectedReplyId" value="${replyList.id }"/>
										<input type="submit" class="btn btn-default" id="deleteReply" value="댓글삭제" formaction="/replyDisable"/>
										<br>
									</c:when>
									<c:otherwise>
										<label class="control-label">삭제된 댓글입니다.</label>
										<br>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<input type="text" id="replyInput" name="replyInput" style="width:300px" placeholder="댓글입력"/>
							<input type="submit" class="btn btn-primary" id="saveReply" value="댓글저장" formaction="/contentDetail"/>
						</div>
					</div>
					

					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="name" class="col-sm-2 control-label">작성자</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<label class="control-label">${contentVo.writer }</label> --%>
<!-- 						</div> -->
<!-- 					</div> -->
				
<!-- 					<div class="form-group"> -->
<!-- 						<label for="call_cnt" class="col-sm-2 control-label">조회수</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<label class="control-label">${contentVo.viewCnt }</label> --%>
<!-- 						</div> -->
<!-- 					</div> -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>
