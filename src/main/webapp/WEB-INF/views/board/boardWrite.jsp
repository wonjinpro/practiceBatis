<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판에 글 작성하기</h2>
	<form action="boardWrite.com" method="post" enctype="multipart/form-data">	
		<table border="1">	
			<tr>
				<th>작성자</th><td><input type="text" value="${sessionScope.m.memberId}" readonly></td>
				<th>제목</th><td><input type="text" name="boardTitle"></td>
				
			</tr>
			<tr>
				<th>내용</th><td colspan="4"><textarea style="width:400px;height:200px;" name="boardContent"></textarea></td>
			</tr>
			<tr>
				<th>파일첨부</th><td><input type="file" name="file" multiple>
				<td><button type="submit">제출하기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>