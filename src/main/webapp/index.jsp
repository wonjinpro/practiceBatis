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
			
			
		</c:otherwise>
	</c:choose>
		
	
	
	
	
</body>
</html>