package kr.or.ddit.content.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.content.service.ContentService;
import kr.or.ddit.content.service.ContentServiceInf;

/**
 * Servlet implementation class ContentDisableServlet
 */
@WebServlet("/contentDisable")
public class ContentDisableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ContentServiceInf contentService = new ContentService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int contentNo = Integer.parseInt(request.getParameter("contentVoNo"));
		
		contentService.disableContent(contentNo);
		
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}

}
