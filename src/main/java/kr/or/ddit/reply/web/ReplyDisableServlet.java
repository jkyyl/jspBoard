package kr.or.ddit.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplyDisableServlet
 */
@WebServlet("/replyDisable")
public class ReplyDisableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ReplyServiceInf replyService = new ReplyService();
		
		int id = Integer.parseInt(request.getParameter("selectedReplyId"));
		replyService.disableReply(id);
		
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}

}
