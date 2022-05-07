<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pg{
		text-decoration:none;
		text-align:center;
	}
</style>
</head>
<body>	
	<h1>게시판 </h1>
	<a href="boardWriteFrm.com">게시판에 글쓰기</a>
	<table border="1">
		<tr>
			<th>게시물 번호</th><th>작성자</th><th>제목</th><th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td><a href="boardViewFrm.com?boardNo=${b.boardNo}">${b.boardNo }</a></td>
			<td>${b.boardWriter }</td>
			<td>${b.boardTitle }</td>
			<td>${b.boardDate }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" id="pg">${pageNavi }</td>
		</tr>
	 </table>
	 <a href="/">화면으로 돌아가기</a>
</body>
</html>