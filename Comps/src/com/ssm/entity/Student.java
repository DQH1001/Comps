package com.ssm.entity;

public class Student {
	private int sid,s_clid;
	private String sname;		
	private String spwd;
	private String sdate,slogo,choose;
	private String ssex,scity,stel,semail,cname,pname,menus;
	private String signature,sresume,ccid,ppid;
	private String[] stumenus;
	private Classes classes;
	
	public String[] getStumenus() {
		return stumenus;
	}
	public void setStumenus(String[] stumenus) {
		this.stumenus = stumenus;
	}
	public String getMenus() {
		return menus;
	}
	public void setMenus(String menus) {
		this.menus = menus;
	}
	public String getCcid() {
		return ccid;
	}
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}

	public Student(){}
	public Student(int sid, String sname, String spwd, String sdate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spwd = spwd;
		this.sdate = sdate;
	}
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSresume() {
		return sresume;
	}
	public void setSresume(String sresume) {
		this.sresume = sresume;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public int getS_clid() {
		return s_clid;
	}
	public void setS_clid(int s_clid) {
		this.s_clid = s_clid;
	}
	public String getSlogo() {
		return slogo;
	}
	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", s_clid=" + s_clid + ", sname=" + sname + ", spwd=" + spwd + ", sdate=" + sdate
				+ ", slogo=" + slogo + ", choose=" + choose + ", ssex=" + ssex + ", scity=" + scity + ", stel=" + stel
				+ ", semail=" + semail + ", classes=" + classes + "]";
	}
	
	
}