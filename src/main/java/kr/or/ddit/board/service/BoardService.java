package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {

	private BoardDaoInf boardDao = new BoardDao();
	
	/**
	 * Method : getBoardList
	 * 최초작성일 : 2018. 7. 21.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판을 가져온다.
	 */
	public List<BoardVo> getBoardList() {
		return boardDao.getBoardList();
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
		return boardDao.getActiveBoardList();
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
		return boardDao.createBoard(boardVo);
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
		return boardDao.updateBoard(boardVo);
	}
}
