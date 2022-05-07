<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateBoard.com" method="post">
		<input type="hidden" name="boardNo" value="${b.boardNo }">
		<table border="1">		
				<tr>
					
					<th>제목</th><td><input type="text" name="boardTitle" value="${b.boardTitle }"></td>
					<th>글쓴이</th><td>${b.boardWriter}</td>
					<th>작성일</th><td>${b.boardDate }</td>
				</tr>
				<tr > 
					<th >내용</th>
					<td colspan="2" rowspan="5"><textarea name="boardContent" style="height:100px;width:300px;">${b.boardContent }</textarea></td>
				</tr>
				
				<tr>
				<td><input type="submit" value="수정"></td> <td><a href="deleteBoard.com?boardNo=${b.boardNo }">삭제하기</a></td> 	
				</tr>
				
			</table>
		</form>
		
</body>
</html>