package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	
	private int id;         //댓글ID
	private int cnt_no;     //게시글번호
	private String content; //댓글내용
	private String active;  //삭제여부
	private String std_id;	//학생ID
	private Date reg_dt;	//등록일
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCnt_no() {
		return cnt_no;
	}
	public void setCnt_no(int cnt_no) {
		this.cnt_no = cnt_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "ReplyVo [id=" + id + ", cnt_no=" + cnt_no + ", content="
				+ content + ", active=" + active + ", std_id=" + std_id
				+ ", reg_dt=" + reg_dt + "]";
	}
	
}
