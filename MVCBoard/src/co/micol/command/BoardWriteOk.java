package co.micol.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardWriteOk implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글 저장
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setwDate(Date.valueOf(request.getParameter("date"))); // date타입으로 변환.
		int n = dao.insert(dto);

		String path = null;
		if (n != 0) {
			path = "boardlist.do"; // 성공시 목록 보여주기
			response.sendRedirect(path);
		} else {
			path = "view/boardInsertFail.jsp"; // 실패 페이지
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

}
