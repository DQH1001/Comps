package com.ssm.entity;

public class Scores {
	private int scid,s_pid,s_cid,s_sid,number,page,limit;
	private String stuname;
	private Comps comps;
	private Projects project;
	private Student stus;
	public Scores() {}
	public Scores(int scid, int s_pid, int s_cid, int s_sid) {
		super();
		this.scid = scid;
		this.s_pid = s_pid;
		this.s_cid = s_cid;
		this.s_sid = s_sid;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}
	public Student getStus() {
		return stus;
	}
	public void setStus(Student stus) {
		this.stus = stus;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Comps getComps() {
		return comps;
	}
	public void setComps(Comps comps) {
		this.comps = comps;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public int getS_pid() {
		return s_pid;
	}
	public void setS_pid(int s_pid) {
		this.s_pid = s_pid;
	}
	public int getS_cid() {
		return s_cid;
	}
	public void setS_cid(int s_cid) {
		this.s_cid = s_cid;
	}
	public int getS_sid() {
		return s_sid;
	}
	public void setS_sid(int s_sid) {
		this.s_sid = s_sid;
	}
	@Override
	public String toString() {
		return "Scores [scid=" + scid + ", s_pid=" + s_pid + ", s_cid=" + s_cid + ", s_sid=" + s_sid + "]";
	}
	
}
