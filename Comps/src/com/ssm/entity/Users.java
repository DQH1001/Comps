package com.ssm.entity;

public class Users {
	private int uid,u_cid,pnum,cnum;
	private String uname,upwd,udate,urose,u_pros,ulogo;
	public Users(int uid, String uname, String upwd, String udate, String urose) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.udate = udate;
		this.urose = urose;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getU_cid() {
		return u_cid;
	}
	public void setU_cid(int u_cid) {
		this.u_cid = u_cid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getUrose() {
		return urose;
	}
	public void setUrose(String urose) {
		this.urose = urose;
	}
	public String getU_pros() {
		return u_pros;
	}
	public void setU_pros(String u_pros) {
		this.u_pros = u_pros;
	}
	public String getUlogo() {
		return ulogo;
	}
	public void setUlogo(String ulogo) {
		this.ulogo = ulogo;
	}
	
}
