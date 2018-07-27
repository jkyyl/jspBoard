package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * Method : getAllReplyList
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 목록을 가져온다.
	 */
	public List<ReplyVo> getReplyListByContent(int cnt_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<ReplyVo> replyList = session.selectList("reply.getReplyListByContent", cnt_no);
		session.close();
		
		return replyList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("reply.createReply", replyVo);
		session.commit();
		session.close();
		
		return resultCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		int nextSeq = session.selectOne("reply.getNextSeq");
		session.close();
		
		return nextSeq;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("reply.disableReply", id);
		session.commit();
		session.close();
		
		return resultCnt;
	}
	
}
