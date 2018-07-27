package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : getBoardList
	 * 최초작성일 : 2018. 7. 21.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판을 가져온다.
	 */
	public List<BoardVo> getBoardList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getBoardList");
		session.close();
		
		return boardList;
	}

	/**
	 * Method : getActiveBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 활성화 상태의 게시판만 가져온다.
	 */
	public List<BoardVo> getActiveBoardList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> activeBoards = session.selectList("board.selectActiveBoard");
		session.close();
		
		return activeBoards;
	}
	
	/**
	 * Method : createBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 추가
	 */
	public int createBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("board.createNewBoard", boardVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}
	
	/**
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 수정
	 */
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}
}
