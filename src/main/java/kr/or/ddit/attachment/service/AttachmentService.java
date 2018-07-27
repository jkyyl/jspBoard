package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoInf;
import kr.or.ddit.attachment.model.AttachmentVo;

import org.apache.ibatis.session.SqlSession;

public class AttachmentService implements AttachmentServiceInf {
	
	private AttachmentDaoInf attachmentDao = new AttachmentDao();

	/**
	 * Method : getAttachmentList
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일을 불러온다.
	 */
	public List<AttachmentVo> getAttachmentList(int content_id) {
		return attachmentDao.getAttachmentList(content_id);
	}
	
	/**
	 * Method : uploadFile
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param attachmentVo
	 * @return
	 * Method 설명 : 첨부파일 VO를 받아 데이터베이스에 저장
	 */
	public int uploadFile(AttachmentVo attachmentVo) {
		return attachmentDao.uploadFile(attachmentVo);
	}

}
