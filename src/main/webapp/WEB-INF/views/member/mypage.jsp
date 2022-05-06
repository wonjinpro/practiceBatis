<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateMember.com" method="post">
		<input type="hidden" name="memberNo" value="${sessionScope.m.memberNo}">
		<div>아이디 : <input type="text" name="memberId" value="${sessionScope.m.memberId }" readonly></div>
		<div>이름 :<input type="text" name="memberName" value="${sessionScope.m.memberName }" ></div>
		<div>이메일 :<input type="text" name="email" value="${sessionScope.m.email }"></div>
		<div>전화번호 : <input type="text" name="phone" value="${sessionScope.m.phone }"></div>
		
		<button type="submit">수정하기</button>
		
	</form>
		<a href="deleteMember.com">회원삭제하기</a>
		<a href="changePw.com">비밀번호 변경하기</a>
		<div><a href="logoutForm.com">로그아웃</a></div>
</body>
</html>