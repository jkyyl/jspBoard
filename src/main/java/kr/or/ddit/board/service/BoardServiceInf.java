package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {
	
	/**
	 * Method : getBoardList
	 * 최초작성일 : 2018. 7. 21.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판을 가져온다.
	 */
	List<BoardVo> getBoardList();

	/**
	 * Method : getActiveBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 활성화 상태의 게시판만 가져온다.
	 */
	List<BoardVo> getActiveBoardList();
	
	/**
	 * Method : createBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 추가
	 */
	int createBoard(BoardVo boardVo);
	
	/**
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 수정
	 */
	int updateBoard(BoardVo boardVo);
}
