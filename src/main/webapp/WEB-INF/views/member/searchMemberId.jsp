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
	<table border="1">
		<tr>
		 	<th>이름</th><th>아이디</th><th>이메일</th><th>번호</th>
		 <tr>
			<c:forEach items="${list}" var="m">	 
				 <tr>
				 	<th>${m.memberName }</th><th>${m.memberId }</th><th>${m.phone }</th><th>${m.email }</th>
				 </tr>
				
			</c:forEach>
	</table>
</body>
</html>