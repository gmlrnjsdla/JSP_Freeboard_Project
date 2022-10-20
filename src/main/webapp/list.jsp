<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글목록</title>
</head>
<body>
	<h2>자유게시판 글목록</h2>
	<hr>
	<table width="600" border="1" cellpadding ="0" cellspacing="0">
		<tr bgcolor = "#CEFBC9">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${list}" var = "dto">
		<tr>
			<td>${dto.bid }</td>
			<td><a href="content_view.do?bid=${dto.bid }">${dto.btitle }</a></td>
			<td>${dto.bname }</td>
			<td>${dto.bdate }</td>
			<td>${dto.bhit }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글쓰기" onclick="javascript:window.location='write_form.do'">
			</td>
		</tr>
	</table>
</body>
</html>