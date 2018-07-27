package kr.or.ddit.content.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.content.service.ContentService;
import kr.or.ddit.content.service.ContentServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/contentList")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		session.setAttribute("board_id", board_id);
		
		
		//========================================================================
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_id", board_id);
		
		ContentServiceInf contentService = new ContentService();
		
		Map<String, Object> resultMap = contentService.getContentPageList(paramMap);
				
		List<ContentVo> contentList = (List<ContentVo>) resultMap.get("pageList");
		session.setAttribute("contentList", contentList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		session.setAttribute("pageNavi", pageNavi);
		
		request.getRequestDispatcher("/content/contentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
