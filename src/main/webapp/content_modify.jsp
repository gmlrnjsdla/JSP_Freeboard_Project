<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글수정</title>
</head>
<body>
	<h2>자유게시판 글 내용 수정</h2>
	<hr>
	<table width="600" border="1" cellpadding="0" cellspacing="0">
	<form action="modify.do">
		<input type="hidden" name="bid" value="${content.bid }">
		<tr>
			<th align="center" bgcolor="#D4F4FA">제 목</th>
			<td><input type="text" value="${content.btitle }" size="80" name="btitle"></td>			
		</tr>
		<tr>
			<th align="center" bgcolor="#D4F4FA">글쓴이</th>
			<td><input type="text" value="${content.bname }" size="80" name="bname"></td>
		</tr>		
		<tr>
			<th align="center" bgcolor="#D4F4FA">등록일</th>
			<td>${content.bdate }</td>
		</tr>
		<tr>
			<th align="center" bgcolor="#D4F4FA">조회수</th>
			<td>${content.bhit }</td>			
		</tr>
		<tr height="200">
			<th valign="top" align="center" bgcolor="#D4F4FA">내 용</th>
			<td valign="top">
				<textarea rows="12" cols="60" name="bcontent">${content.bcontent }</textarea>
			</td>			
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정완료">				
				<input type="button" value="글목록" onclick="javascript:window.location='list.do'">
			</td>
		</tr>
	</form>
	</table>
</body>
</html>