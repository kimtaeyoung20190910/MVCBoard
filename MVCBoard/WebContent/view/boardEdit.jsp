<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div align="center">
		<div>
			<h2>게시글 수정</h2>
		</div>
		<div>
			<form id="frm" name="frm" action="boardEditOk.do" method="post">
			<input type="hidden" id="id" name="id" value="${dto.id }">
			<table border="1">
			<tr>
				<th align="center" width="70">작성자</th>
				<td align="center" width="100">${dto.name }</td>
				<th align="center" width="70">작성일자</th>
				<td align="center" width="100">${dto.wDate }</td>
				<th align="center" width="70">조회수</th>
				<td align="center" width="70">${dto.hit }</td>
			</tr>
			<tr>
				<th align="center" width="70">제목</th>
				<td colspan="5">
				<input type="text" id="title" name="title" size="70" value="${dto.title }"></td>
			</tr>
			<tr>
				<th align="center" width="70">내용</th>
				<td colspan="5" height="100">
			<textarea rows="15" cols="70" id="contents" name="contents">${dto.contents }</textarea></td>
			</tr>
			</table>
			<br/>
			<input type="submit" value="저장"> &nbsp;&nbsp;
			<input type="reset" value="취소"> &nbsp;&nbsp;
			<button type="button" onclick="location.href='boardlist.do'">목록</button>
			</form>
		</div>
	</div>
</body>
</html>