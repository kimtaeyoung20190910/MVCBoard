package co.micol.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;

public class BoardDelete implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		int id = Integer.parseInt(request.getParameter("id"));
		int n = dao.delete(id);

		String path;
		if (n == 0)
			path = "view/boardInsertFail.jsp";
		else
			path = "boardlist.do";

		response.sendRedirect(path); // request 객체를 전달할 필요가 없을 때

	}

}
