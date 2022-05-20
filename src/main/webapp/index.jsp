<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#ff>input{
		display:block;
		margin:4px;
	}
	a{
		padding-bottom:10px;	
	}
</style>
</head>
<body>
	
	<c:choose>
		<c:when test="${empty sessionScope.m.memberId }">
			<form action="loginForm.com" method="post">
			
				<fieldset id="ff">
					<legend>로그인</legend>
						<input type="text" name="memberId">
						<input type="password" name="memberPw">
						<button type="submit">로그인</button>
				</fieldset>
			</form>
			<div><a href="signUpFrm.com">회원가입</a></div>
		</c:when>
		<c:otherwise>
			<h1>[${sessionScope.m.memberName }]님 환영합니다</h1>
			<div><a href="logoutForm.com">로그아웃</a></div>
			<div><a href="mypageFrm.com">마이페이지</a></div>
			<h2><a href="boardList.com?reqPage=1">게시판 글 보기</a></h2>
			
		</c:otherwise>
	</c:choose>
	
	<h2>조회하기</h2>
	<form action="searchOneId.com" method="post">
		<span><input type="text" name="memberId">
			<button type="submit">회원조회하기</button>		
		</span>
	</form>
	
	<h2>여러명 조회하기</h2>
	<form action="searchMemberId.com" method="post">
		<span>
			<input type="text" name="keyword">
			<button type="submit">키워드로 검색하기</button>
		</span>
	</form>
	
	
	<h3>아이디나 이름으로 조회하기</h3>
	<form action="idOrName.com">
		<div>아이디 : <input type="text" name="memberId"></div>
		<div>이름 : <input type="text" name="memberName"></div>
		<button>검색</button>
	</form>
	<h3>선택해서 조회하기</h3>
	<a href="searchMember3Frm.com">선택해서 조회하기</a>
	
	
	
	
	
	
	
	
</body>
</html>