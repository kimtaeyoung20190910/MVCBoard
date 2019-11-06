package co.micol.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.BoardDelete;
import co.micol.command.BoardEdit;
import co.micol.command.BoardEditOk;
import co.micol.command.BoardList;
import co.micol.command.BoardReply;
import co.micol.command.BoardView;
import co.micol.command.BoardWrite;
import co.micol.command.BoardWriteOk;
import co.micol.command.Command;
import co.micol.command.MainCommand;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Command> list = null;   
    
    public FrontController() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Command>();
		list.put("/index.do", new MainCommand()); //url에서 index.do로 오면 MainCommand 실행.	
		list.put("/boardlist.do", new BoardList()); //목록보기
		list.put("/boardEdit.do", new BoardEdit()); //글 수정
		list.put("/boardwrite.do", new BoardWrite()); //글 쓰기
		list.put("/boardWriteOk.do", new BoardWriteOk()); //글 저장
		list.put("/boardView.do", new BoardView()); // 글 보기
		list.put("/boardEditOk.do", new BoardEditOk()); // 글 수정 저장
		list.put("/boardDelete.do", new BoardDelete()); //글 삭제
		list.put("/boardReply.do", new BoardReply()); //댓글 달기
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		String context = request.getContextPath();
		String path = url.substring(context.length()); 
		Command subcommand = list.get(path);
		subcommand.excute(request, response);
	}

}
