package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {

	private int id;			//게시판번호
	private String name;    //게시판이름
	private String active;	//사용여부
	private String writer;	//작성자
	private Date reg_dt;    //작성일시
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", name=" + name + ", active=" + active
				+ ", writer=" + writer + ", reg_dt=" + reg_dt + "]";
	}
	
}
