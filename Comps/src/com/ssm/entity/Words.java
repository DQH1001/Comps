package com.ssm.entity;

public class Words {
	private int wid,w_cid,w_sid,wcount,whid;
	private String wtitle,wcontent,wdate,wimages,wtest,wauthor;
	private Comps comp;
	private Student stu;
	public Words() {}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getW_cid() {
		return w_cid;
	}
	public void setW_cid(int w_cid) {
		this.w_cid = w_cid;
	}
	public int getW_sid() {
		return w_sid;
	}
	public void setW_sid(int w_sid) {
		this.w_sid = w_sid;
	}
	public int getWcount() {
		return wcount;
	}
	public void setWcount(int wcount) {
		this.wcount = wcount;
	}
	public int getWhid() {
		return whid;
	}
	public void setWhid(int whid) {
		this.whid = whid;
	}
	public String getWtitle() {
		return wtitle;
	}
	public void setWtitle(String wtitle) {
		this.wtitle = wtitle;
	}
	public String getWcontent() {
		return wcontent;
	}
	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getWimages() {
		return wimages;
	}
	public void setWimages(String wimages) {
		this.wimages = wimages;
	}
	public String getWtest() {
		return wtest;
	}
	public void setWtest(String wtest) {
		this.wtest = wtest;
	}
	public String getWauthor() {
		return wauthor;
	}
	public void setWauthor(String wauthor) {
		this.wauthor = wauthor;
	}
	public Comps getComp() {
		return comp;
	}
	public void setComp(Comps comp) {
		this.comp = comp;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "Words [wid=" + wid + ", w_cid=" + w_cid + ", w_sid=" + w_sid + ", wcount=" + wcount + ", whid=" + whid
				+ ", wtitle=" + wtitle + ", wcontent=" + wcontent + ", wdate=" + wdate + ", wimages=" + wimages
				+ ", wtest=" + wtest + ", wauthor=" + wauthor + ", comp=" + comp + ", stu=" + stu + "]";
	};
	
}
