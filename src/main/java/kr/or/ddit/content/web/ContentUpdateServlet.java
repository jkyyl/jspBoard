package kr.or.ddit.content.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.content.service.ContentService;
import kr.or.ddit.content.service.ContentServiceInf;

/**
 * Servlet implementation class ContentUpdate
 */
@WebServlet("/contentUpdate")
public class ContentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContentServiceInf contentService = new ContentService();
		AttachmentServiceInf attachService = new AttachmentService();
		
		int contentNo = Integer.parseInt(request.getParameter("contentVoNo"));
		
		ContentVo contentVo = contentService.getContentByNo(contentNo);
		List<AttachmentVo> attachList = attachService.getAttachmentList(contentNo);
		
		request.setAttribute("contentVo", contentVo);
		request.setAttribute("attachList", attachList);
		
		request.getRequestDispatcher("/content/contentWrite.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
	}

}
