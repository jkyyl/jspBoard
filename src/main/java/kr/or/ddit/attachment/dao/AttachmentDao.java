package kr.or.ddit.attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class AttachmentDao implements AttachmentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : getAttachmentList
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일을 불러온다.
	 */
	public List<AttachmentVo> getAttachmentList(int content_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AttachmentVo> attachmentList = session.selectList("attachment.getAttachmentList", content_id);
		session.close();
		
		return attachmentList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("attachment.uploadFile", attachmentVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}

}
