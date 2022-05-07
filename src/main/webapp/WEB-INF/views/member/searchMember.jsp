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
	<h2>선택해서 값 가져오기 </h2>
	<form action="searchMembers.com" method="post">	
			<table border="1">
				<tr>
					<th>아이디</th>
				</tr>
				<c:forEach items="${list }" var="m">
					
					<tr>
						<td><input type="checkBox" name="memberId" value="${m.memberId }">${m.memberId }</td>
					</tr>
					
				</c:forEach>
				
			</table>	
		<button type="submit">선택한 회원으로 조회하기</button>
	</form>	
</body>
</html>