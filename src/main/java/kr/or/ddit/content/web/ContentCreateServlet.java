package kr.or.ddit.content.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.attachment.web.AttachmentUtil;
import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.content.service.ContentService;
import kr.or.ddit.content.service.ContentServiceInf;

/**
 * Servlet implementation class ContentCreateServlet
 */
@WebServlet("/contentCreate")
@MultipartConfig(maxFileSize=5120000, maxRequestSize=1024*1000*16)
public class ContentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContentServiceInf contentService = new ContentService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("contentVoNo") != null) {
			int parentNo = Integer.parseInt(request.getParameter("contentVoNo"));
			request.setAttribute("parentNo", parentNo);
		}
		
		request.getRequestDispatcher("/content/contentWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
	    String title = request.getParameter("title");
	    String content = request.getParameter("smarteditor");
	    int no = 0;
		if (request.getParameter("contentVoNo") != null) {
			no = Integer.parseInt(request.getParameter("contentVoNo"));
		}
	    boolean conflict = false;
	    
	    ContentVo contentVo = new ContentVo();
	    contentVo.setTitle(title);
	    contentVo.setContent(content);
	    contentVo.setWriter((String)session.getAttribute("userId"));
	    contentVo.setId((String)session.getAttribute("userId"));
	    contentVo.setBoard_id((Integer)session.getAttribute("board_id"));
	    
	    System.out.println(contentVo.getTitle());
	    System.out.println(contentVo.getContent());
	    System.out.println(contentVo.getWriter());
	    System.out.println(contentVo.getId());
	    System.out.println(contentVo.getBoard_id());
	    
	    if (no != 0) {
			contentVo.setNo(no);
		} else if (contentVo.getNo() == 0) {
	    	int nextSeq = contentService.getNextSeq();
	    	contentVo.setNo(nextSeq);
	    	conflict = true;
		}
	    
	    if (!request.getParameter("parentNo").isEmpty()) {
			contentVo.setPno(Integer.parseInt(request.getParameter("parentNo")));
		}
	    
	    if (contentService.getLastGno()==0) {
	    	contentVo.setGno(1);
	    } else if (contentVo.getPno()==0) {
	    	int lastGno = contentService.getLastGno();
	    	lastGno++;
	    	contentVo.setGno(lastGno);
	    } else {
	    	contentVo.setGno(contentService.getLastGno());
	    }
	    
	    ContentServiceInf contentService = new ContentService();
	    if (conflict) {
	    	contentService.createContent(contentVo);
		} else {
			contentService.updateContent(contentVo);
		}
	    
	    //=================================================== 첨부파일 ====
	    
	    AttachmentVo attachmentVo = new AttachmentVo();
	    AttachmentServiceInf attachmentService = new AttachmentService();
	    
	    int contentNo = contentVo.getNo();

		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			
			if (part.getContentType() != null) {

				String contentDisposition = part.getHeader("Content-disposition");
				String filename = AttachmentUtil.getFileName(contentDisposition);

				String path = AttachmentUtil.fileUploadPath;

				if (part.getSize() > 0) {

					String picName = UUID.randomUUID().toString();
					part.write(path + File.separator + picName);
					part.delete();

					if (!filename.equals(null)) {
						attachmentVo.setUp_name(filename);
						attachmentVo.setFname(picName);
						attachmentVo.setFpath(path + File.separator + picName);
						attachmentVo.setContent_no(contentNo);
						
						attachmentService.uploadFile(attachmentVo);
					}
				}
			}
		}
		
	    request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}

}
