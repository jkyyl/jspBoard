package kr.or.ddit.attachment.model;

public class AttachmentVo {
	
	private int id;			//첨부파일ID
	private int content_no; //게시글번호
	private String up_name; //업로드파일명
	private String fpath;   //파일경로
	private String fname;   //파일명
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getContent_no() {
		return content_no;
	}
	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}
	public String getUp_name() {
		return up_name;
	}
	public void setUp_name(String up_name) {
		this.up_name = up_name;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "AttachmentVo [id=" + id + ", content_no=" + content_no
				+ ", up_name=" + up_name + ", fpath=" + fpath + ", fname="
				+ fname + "]";
	}
	
}
