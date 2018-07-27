package kr.or.ddit.content.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.content.dao.ContentDao;
import kr.or.ddit.content.dao.ContentDaoInf;
import kr.or.ddit.content.model.ContentVo;
import kr.or.ddit.student.model.StudentVo;

public class ContentService implements ContentServiceInf {
	
	private ContentDaoInf contentDao= new ContentDao();
	
	/**
	 * Method : getAllContent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 해당게시판 글들을 불러온다.
	 */
	public List<ContentVo> getAllContent() {
		return contentDao.getAllContent();
	}
	
	/**
	 * Method : getContentPage
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 페이지 리스트 조회
	 */
	public Map<String, Object> getContentPageList(Map<String, Integer> map) {
		
		int board_id = map.get("board_id");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<ContentVo> pageList = contentDao.getContentPageList(map);
		resultMap.put("pageList", pageList);
		
		int totCnt = contentDao.countContentByBoard(board_id);
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, board_id));
		
		return resultMap;
	}
	
	/**
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return
	 * Method 설명 : 페이지 네이게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt, int board_id) {
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		pageNaviStr.append("<li><a href=\"/contentList?page=" + 1 + "&pageSize=" + pageSize + "&board_id=" + board_id + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/contentList?page=" + prevPage + "&pageSize=" + pageSize + "&board_id=" + board_id + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if ( i == page) 
				activeClass = "class=\"active\"";
				pageNaviStr.append("<li " + activeClass + "><a href=\"/contentList?page=" + i +
						"&pageSize=" + pageSize + "&board_id=" + board_id + "\">" + i + "</a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/contentList?page=" + nextPage + "&pageSize=" + pageSize + "&board_id=" + board_id + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/contentList?page=" + cnt + "&pageSize=" + pageSize + "&board_id=" + board_id + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
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
		return contentDao.countAllContent();
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
		return contentDao.createContent(contentVo);
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
		return contentDao.getLastGno();
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
		return contentDao.getNextSeq();
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
		return contentDao.getContentByNo(no);
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
		return contentDao.disableContent(no);
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
		return contentDao.countContentByBoard(board_id);
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
		return contentDao.updateContent(contentVo);
	}
}
