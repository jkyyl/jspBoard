package kr.or.ddit.content.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.student.model.StudentVo;

public interface ContentDaoInf {
	
	/**
	 * Method : getAllContent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 해당게시판 글들을 불러온다.
	 */
	List<ContentVo> getAllContent();
	
	/**
	 * Method : getContentPage
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 페이지 리스트 조회
	 */
	List<ContentVo> getContentPageList(Map<String, Integer> map); 
	
	/**
	 * Method : countAllContent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 내 전체 글 수를 반환한다.
	 */
	int countAllContent();
	
	/**
	 * Method : createContent
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 새 게시글 작성
	 */
	int createContent(ContentVo contentVo);
	
	/**
	 * Method : getLastGno
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 가장 마지막 GNO 가져오기
	 */
	int getLastGno();
	
	/**
	 * Method : getNextSeq
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 출력될 시퀀스값을 가져온다.
	 */
	int getNextSeq();
	
	/**
	 * Method : getContentByNo
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param no
	 * @return
	 * Method 설명 : no값을 받아 해당 게시글을 호출한다.
	 */
	ContentVo getContentByNo(int no);
	
	/**
	 * Method : disableContent
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : content를 비활성화한다.
	 */
	int disableContent(int no);
	
	/**
	 * Method : countContentByBoard
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : board_id를 가진 게시글 수를 샌다.
	 */
	int countContentByBoard(int board_id);
	
	/**
	 * Method : updateContent
	 * 최초작성일 : 2018. 7. 26.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param contentVo
	 * @return
	 * Method 설명 : vo를 받아 게시글을 수정한다.
	 */
	int updateContent(ContentVo contentVo);
	
}
