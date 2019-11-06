<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function formCheck(){
		if(frm.name.value == "") {
			alert("작성자를 입력하세요.");
			frm.name.focus();
			return false;
		}
		if(frm.title.value == "") {
			alert("제목을 입력하세요.");
			frm.name.focus();
			return false;
		}
		if(frm.contents.value == ""){
			alert("내용을 입력하세요.");
			frm.contents.focus();
			return false;
		}
		return true;
	}
	
</script>
<body>
<div align="center">
		<div><h2>게시글 작성</h2></div>
		<div>
		<form id="frm" name="frm" action="boardWriteOk.do" method="post" onsubmit="return formCheck()">
			<table border="1">
			<tr>
				<th align="center" width="70">* 작성자</th>
				<td><input type="text" id="name" name="name"></td>
				<th align="center" width="70">작성일자</th>
				<td><input type="date" id="date" name="date"></td>
			</tr>
			<tr>
				<th align="center" width="70">* 제목</th>
				<td colspan="3"><input type="text" id="title" name="title" size="70"></td>
			</tr>
			<tr>
				<th align="center" width="70">* 내용</th>
				<td colspan="3"><textarea rows="15" cols="70" id="contents" name="contents"></textarea></td>
			</tr>
			</table>
			<div>
				<br/>
				<input type="submit" value="저장">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardlist.do'">목록보기</button>
			</div>
			</form>
		</div>
	<script> document.getElementById('date').value = new Date().toISOString().substring(0, 10);</script>
	</div>
</body>
</html>