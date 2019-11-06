<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formSubmit(n) {
		if(n==1)
			frm.action = "boardReplyOk.do";
			else
			frm.action = "boardView.do";
			
			frm.submit();
	}	
</script>
</head>
<body>
	<div align="center">
		<div>
			<h2>게시글 댓글 달기</h2>
		</div>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<input type="hidden" id="id" name="id" value="${dto.id }"> <input
					type="hidden" id="group" name="group" value="${dto.group }">
				<input type="hidden" id="step" name="step" value="${dto.step }">
				<input type="hidden" id="indent" name="indent"
					value="${dto.indent }">
				<div>
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
							<td colspan="5">${dto.title }</td>
						</tr>
						<tr>
							<th align="center" width="70">내용</th>
							<td colspan="10" height="100">${dto.contents }</td>
						</tr>
					</table>
				</div>
				<div>
					<br />
					<table border="1">
						<tr>
							<th width="60">댓글</th>
							<td colspan="5"><textarea rows="5" cols="60" id="reply"
									name="reply"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<br />
					<button type="button" onclick="formSubmit(1)">저장</button>
					&nbsp;&nbsp;
					<button type="button" onclick="formSubmit(2)">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>