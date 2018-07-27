package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Servlet implementation class BoardCreateServlet
 */
@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceInf boardService = new BoardService();

		List<BoardVo> activeBoards = boardService.getActiveBoardList();
		HttpSession session = request.getSession();
		session.setAttribute("activeBoards", activeBoards);
		
		List<BoardVo> boardList = boardService.getBoardList();
		session.setAttribute("boardList", boardList);
		
		for (BoardVo board : boardList) {
			String isYn = board.getActive();
			isYn = isYn == null ? "Y" : isYn;
			request.setAttribute(Integer.toString(board.getId()), isYn);
		}
		
		
		request.getRequestDispatcher("/jsp/createBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		BoardServiceInf boardService = new BoardService();
		
		BoardVo boardVo = new BoardVo();
		boardVo.setId(Integer.parseInt(request.getParameter("boardId")));
		boardVo.setName(request.getParameter("boardName"));
		boardVo.setActive(request.getParameter("isYn"));
		boardVo.setWriter((String)session.getAttribute("userId"));
		
		List<BoardVo> boardListCheck = (List<BoardVo>) session.getAttribute("boardList");
		boolean uniqueName = false;
		for (BoardVo vo : boardListCheck) {
			if(vo.getName().equals(boardVo.getName())) {
				uniqueName = true;
			}
		}
		
		if (uniqueName) {
			System.out.println("게시판이름 중복");
		} else if (request.getParameter("boardId").equals("0")) {
			boardService.createBoard(boardVo);
		} else {
			boardService.updateBoard(boardVo);
		}
		
		List<BoardVo> boardList = boardService.getBoardList();
		session.setAttribute("boardList", boardList);

		List<BoardVo> activeBoards = boardService.getActiveBoardList();
		session.setAttribute("activeBoards", activeBoards);
		
		request.getRequestDispatcher("/jsp/createBoard.jsp").forward(request, response);
	}

}
