package kr.or.ddit.content.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class ContentDao implements ContentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : getAllContent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 해당게시판 글들을 불러온다.
	 */
	public List<ContentVo> getAllContent() {
		SqlSession session = sqlSessionFactory.openSession();
		List<ContentVo> contentList = session.selectList("content.selectAllContent");
		session.close();
		
		return contentList;
	}
	
	/**
	 * Method : getContentPage
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 페이지 리스트 조회
	 */
	public List<ContentVo> getContentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<ContentVo> contentPageList = session.selectList("content.getContentPageList", map);
		session.close();
		
		return contentPageList;
	}
	
	/**
	 * Method : countAllContent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 내 전체 글 수를 반환한다.
	 */
	public int countAllContent() {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("content.countAllContent"); 
		session.close();
		
		return totCnt;
	}
	
	/**
	 * Method : createContent
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 새 게시글 작성
	 */
	public int createContent(ContentVo contentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.update("content.createContent", contentVo);
		session.commit();
		session.close();
		
		return totCnt;
	}
	
	/**
	 * Method : getLastGno
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 가장 마지막 GNO 가져오기
	 */
	public int getLastGno() {
		SqlSession session = sqlSessionFactory.openSession();
		int gno = 0;
		try {
			gno = session.selectOne("content.getLastGno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return gno;
	}
	
	/**
	 * Method : getNextSeq
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 출력될 시퀀스값을 가져온다.
	 */
	public int getNextSeq() {
		SqlSession session = sqlSessionFactory.openSession();
		int nextSeq = session.selectOne("content.getNextSeq");
		session.close();
		
		return nextSeq;
	}
	
	/**
	 * Method : getContentByNo
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param no
	 * @return
	 * Method 설명 : no값을 받아 해당 게시글을 호출한다.
	 */
	public ContentVo getContentByNo(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		ContentVo contentVo = session.selectOne("content.getContentByNo", no);
		session.close();
		
		return contentVo;
	}
	
	/**
	 * Method : disableContent
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : content를 비활성화한다.
	 */
	public int disableContent(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("content.disableContent", no);
		session.commit();
		session.close();
		
		return resultCnt;
	}
	
	/**
	 * Method : countContentByBoard
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : board_id를 가진 게시글 수를 샌다.
	 */
	public int countContentByBoard(int board_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("content.countContentByBoard", board_id);
		session.close();
		
		return totCnt;
	}
	
	/**
	 * Method : updateContent
	 * 최초작성일 : 2018. 7. 26.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param contentVo
	 * @return
	 * Method 설명 : vo를 받아 게시글을 수정한다.
	 */
	public int updateContent(ContentVo contentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("updateContent");
		session.commit();
		session.close();
		
		return resultCnt;
	}
	
}
