<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<style>
#cross {
/*   position: absolute; */
  background: gray;
  height: 25px;
  position: relative;
  left: 12px;
  top: 12px;
  width: 5px;
}
#cross:after {
  background: gray;
  content: "";
  height: 5px;
  left: -10px;
  position: absolute;
  top: 10px;
  width: 25px;
}
</style>

</head>

<body>

	<!-- top.jsp -->
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
			<div>
				<h2 class="form-signin-heading">새글 쓰기</h2>
			</div>
			
			<form id="contentCreate" action="/contentCreate" method="post" enctype="multipart/form-data" >
			
			<input type="hidden" id="contentVo" name="contentVo" value="${contentVo }"/>
			<input type="hidden" id="contentVoNo" name="contentVoNo" value="${contentVo.no }"/>
			<input type="hidden" id="attachList" name="attachList" value="${attachList }"/>
			
			<table width="100%">
		        <tr>
		            <td>제목</td>
		            <td><input type="text" id="title" name="title" style="width:650px" value="${contentVo.title }"/></td>
		        </tr>
		        <tr>
		            <td>내용</td>
		            <td>
<!-- 		                <textarea rows="10" cols="30" id="ir1" id="content" name="content" style="width:650px; height:350px; "></textarea> -->
		                <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${contentVo.content }</textarea> 
		            </td>
		        </tr>
		        <tr>
		            <td>첨부파일</td>
		            <td>
		            	<c:forEach items="${attachList}" var="attachList">
							<label class="control-label">${attachList.up_name}</label>
							<br>
		            	</c:forEach>
		                <input id="attach" class="hidden" type="file" name="file"/>
		                <input type="file" name="uploadfile" id="img" style="display:none;"/>
		                <input id="boardName" name="boardName" class="form" placeholder="첨부파일을 추가하세요" readonly>
		               	<label id="cross" for="attach"></label>
		            </td>
		        </tr>
		        
		        
		        <tr>
			        <td>
<%-- 				        <c:set value="${parentNo}" var="parentNo"></c:set> --%>
				        <input type="hidden" name="parentNo" value="${parentNo}"/>
			        </td>
			        
		            <td colspan="2">
		            	<input id="save" type="button" class="btn btn-primary" type="button" value="저장"/>
		            </td>
		        </tr>
			</table>
			</form>


			</div>
		</div>
	</div>
</body>
</html>
