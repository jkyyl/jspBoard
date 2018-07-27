<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

<%@ include file="/common/jquery.jsp"%>

<script>
// 	$(function() {
// 		$("#submitBtn").on("click", function() {
// 			if ($("#userId").val().lenth < 1 || $("#userId").val() == "") {
// 				alert("아이디를 입력해주세요");
// 				$("#userId").focus();
// 				return false;
// 			} 

// 			if ($("#userPw").val().length < 1) {
// 				alert("비밀번호를 입력해주세요");
// 				$("#userPw").focus();
// 				return false;
// 			} 
			
// 			$("#frm").submit();
// 		});
// 	});
</script>
</head>

<body>

	<div class="container">
      <form class="form-signin" action="/loginServlet" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">userId</label>
        
        <%
//         	String userId = request.getParameter("userId");
//         	userId = userId == null ? "" : userId;
        %>
        
        
        <input type="text" id="userId" name="userId" class="form-control" placeholder="ID" required autofocus>
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="userPw" name="userPw" class="form-control" placeholder="password" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberMe" name="rememberMe" value=""> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
	</div>

</body>

</html>