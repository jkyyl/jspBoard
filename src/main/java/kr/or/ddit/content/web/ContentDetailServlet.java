package kr.or.ddit.content.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.content.service.ContentService;
import kr.or.ddit.content.service.ContentServiceInf;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/contentDetail")
public class ContentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 no를 파라미터 확인
		int no = Integer.parseInt(request.getParameter("id"));
		
		//service 게시글 정보를 조회
		ContentServiceInf contentService = new ContentService();
		ContentVo contentVo = contentService.getContentByNo(no);
		
		ReplyServiceInf replyService = new ReplyService();
		List<ReplyVo> replyList = replyService.getReplyListByContent(no);
		
		AttachmentServiceInf attachmentService = new AttachmentService();
		List<AttachmentVo> attachmentList = attachmentService.getAttachmentList(no);
		
		//request 객체에 저장
		request.setAttribute("contentVo", contentVo);
		request.setAttribute("replyList", replyList);
		request.setAttribute("attachmentList", attachmentList);
		
		// /content/contentDetail.jsp 로 위임
		request.getRequestDispatcher("/content/contentDetail.jsp")
				.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		ReplyServiceInf replyService = new ReplyService();
		int nextSeq = replyService.getNextSeq();
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setId(nextSeq);
		replyVo.setStd_id((String)session.getAttribute("userId"));
		replyVo.setContent(request.getParameter("replyInput"));
		replyVo.setCnt_no(Integer.parseInt(request.getParameter("contentVoNo")));
		
	    replyService.createReply(replyVo);
		
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}

}
