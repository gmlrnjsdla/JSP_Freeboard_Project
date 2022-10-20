<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글보기</title>
</head>
<body>
	<h2>자유게시판 글보기</h2>
	<hr>
	<table width="600" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" bgcolor="#D4F4FA">제 목</td>
			<td>${content.btitle }</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">작성자</td>
			<td>${content.bname }</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">등록일</td>
			<td>${content.bdate }</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">조회수</td>
			<td>${content.bhit }</td>
		</tr>
		<tr height="200">
			<td valign ="top">내 용</td>
			<td valign ="top">${content.bcontent }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" onclick="javascript:window.location='content_modify.do?bid=${content.bid}'">
				<input type="button" value="삭제">
				<input type="button" value="목록" onclick="javascript:window.location='list.do'">
			</td>
		</tr>
	</table>
</body>
</html>