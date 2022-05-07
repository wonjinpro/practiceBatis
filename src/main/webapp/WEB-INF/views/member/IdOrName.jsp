<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>아이나 비밀번호로 구하기</h4>
	<table border="1">
		<tr>
			<th>이름</th>아이디<th>이메일</th><th>핸드폰</th>
		</tr>
		<c:forEach items="${list }" var="m">
			<tr>
				<td>${m.memberName }</td>
				<td>${m.memberId }</td>
				<td>${m.phone }</td>
				<td>${m.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>