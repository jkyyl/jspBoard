<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/jsp/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/boardCreate">게시판 추가 / 수정</a></li>
		
		<c:forEach items="${activeBoards }" var="activeBoard">
			<li><a href="/contentList?page=1&pageSize=10&board_id=${activeBoard.id }">${activeBoard.name }</a></li>
		</c:forEach>
	</ul>
</div>