<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function transData(n){
		frm.id.value=n;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div><h1>게시판 목록</h1></div>
		<div>
		<form id="frm" name="frm" action="boardView.do" method="post">
			<input type="hidden" id="id" name="id">
			<table border="1">
			<tr>
				<th align="center" width="40">순번</th>
				<th align="center" width="70">작성자</th>
				<th align="center" width="200">제 목</th>
				<th align="center" width="100">작성일자</th>
				<th align="center" width="50">조회수</th>
			</tr>
			<c:forEach var="dto" items="${list }">
				<tr onmouseover="this.style.backgroundColor='#FFFF99'"
					onmouseout="this.style.backgroundColor=''"
					onClick="transData(${dto.id})">
					<td align="center"> ${dto.id }</td>
					<td align="center"> ${dto.name }</td>
					<td align="center"> ${dto.title }</td>
					<td align="center"> ${dto.wDate }</td>
					<td align="center"> ${dto.hit }</td>
				</tr>
			</c:forEach>
			</table>
			</form>
			<div>
				<br/>
				<button type="button" onclick="location.href='boardwrite.do'">글쓰기</button>
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='index.do'">홈가기</button>
			</div>
		</div>
	
	</div>
</body>
</html>