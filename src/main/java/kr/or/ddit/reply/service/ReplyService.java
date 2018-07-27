package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoInf;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceInf {
	
	private ReplyDaoInf replyDao = new ReplyDao(); 
	
	/**
	 * Method : getAllReplyList
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 목록을 가져온다.
	 */
	public List<ReplyVo> getReplyListByContent(int cnt_no) {
		return replyDao.getReplyListByContent(cnt_no);
	}
	
	/**
	 * Method : createReply
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : replyVo
	 */
	public int createReply(ReplyVo replyVo) {
		return replyDao.createReply(replyVo);
	}
	
	/**
	 * Method : getNextSeq
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 출력될 시퀀스값을 가져온다.
	 */
	public int getNextSeq() {
		return replyDao.getNextSeq();
	}
	
	/**
	 * Method : disableReply
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : reply id값으로 disable
	 */
	public int disableReply(int id) {
		return replyDao.disableReply(id);
	}
	
}
