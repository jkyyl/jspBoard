package kr.or.ddit.attachment.dao;

import java.util.List;

import kr.or.ddit.attachment.model.AttachmentVo;

public interface AttachmentDaoInf {

	/**
	 * Method : getAttachmentList
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일을 불러온다.
	 */
	List<AttachmentVo> getAttachmentList(int content_id);
	
	/**
	 * Method : uploadFile
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param attachmentVo
	 * @return
	 * Method 설명 : 첨부파일 VO를 받아 데이터베이스에 저장
	 */
	int uploadFile(AttachmentVo attachmentVo);
}
