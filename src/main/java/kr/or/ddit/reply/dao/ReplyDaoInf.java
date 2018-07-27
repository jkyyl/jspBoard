package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyDaoInf {

	/**
	 * Method : getAllReplyList
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 목록을 가져온다.
	 */
	List<ReplyVo> getReplyListByContent(int cnt_no);
	
	/**
	 * Method : createReply
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : replyVo
	 */
	int createReply(ReplyVo replyVo);
	
	/**
	 * Method : getNextSeq
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 출력될 시퀀스값을 가져온다.
	 */
	int getNextSeq();
	
	/**
	 * Method : disableReply
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : reply id값으로 disable
	 */
	int disableReply(int id);
}
