package kr.or.ddit.content.model;

import java.util.Date;

public class ContentVo {

	private int no;			//게시글번호
	private int board_id;    //게시판번호
	private String title;   //제목
	private String content; //글내용
	private String writer;  //작성자
	private Date regDt;     //작성일시
	private String active;  //삭제여부
	private int gno;        //게시글그룹번호
	private int pno;        //부모게시글번호
	private String id;      //학생ID
	private int viewCnt;    //조회
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "ContentVo [no=" + no + ", board_id=" + board_id + ", title="
				+ title + ", content=" + content + ", writer=" + writer
				+ ", regDt=" + regDt + ", active=" + active + ", gno=" + gno
				+ ", pno=" + pno + ", id=" + id + ", viewCnt=" + viewCnt + "]";
	}
	
}
