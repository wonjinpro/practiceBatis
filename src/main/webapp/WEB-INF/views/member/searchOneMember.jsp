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
	<c:if test="${not empty m.memberId}">
		<table border="1">
			<tr>
				<th>이름</th><th>아이디</th><th>이메일</th><th>번호</th>
			</tr>
			<tr>
				<td>${m.memberName}</td><td>${m.memberId }</td><td>${m.email }</td><td>${m.phone }</td>
			</tr>
		</table>
	</c:if>
	<a href="/">메인홈페이지로 돌아가기</a>
</body>
</html>