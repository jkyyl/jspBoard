package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
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
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		session.setAttribute("userId", userId);
		String userPw = request.getParameter("userPw");
		String encryptPw = KISA_SHA256.encrypt(userPw);
		
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudentVoById(userId);
		
		response.setContentType("text/html;charset=UTF-8");
		
		BoardServiceInf boardService = new BoardService();
		
		List<BoardVo> boardList = boardService.getBoardList();
		session.setAttribute("boardList", boardList);
		
		List<BoardVo> activeBoards = boardService.getActiveBoardList();
		session.setAttribute("activeBoards", activeBoards);
		
		if (studentVo != null && studentVo.validateStudent(userId, encryptPw)) {
			session.setAttribute("studentVo", studentVo);
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		System.out.println("encryptPw : " + encryptPw);
		
	}

}
