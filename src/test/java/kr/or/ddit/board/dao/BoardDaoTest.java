package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf boardDao;
	
	@Before
	public void setup() {
		boardDao = new BoardDao();
	}

	/**
	 * Method : test
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 : 활성화 게시판 출력을 테스트, 활성화된 게시판 수를 반환
	 */
	@Test
	public void getActiveBoardListTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardDao.getActiveBoardList();
		
		for (BoardVo vo : boardList) {
			System.out.println(vo);
		}

		/***Then***/
		assertEquals(4, boardList.size());
	}
	
	
	@Test
	public void createBoardTest() {
		/***Given***/

		/***When***/
		int result = boardDao.createBoard("으아아");

		/***Then***/
		assertEquals(1, result);
	}
}
