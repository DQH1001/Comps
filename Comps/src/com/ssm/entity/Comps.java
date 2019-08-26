package com.ssm.entity;

import java.util.List;

public class Comps {
	private int cid=0,c_tid,numbers=-1,ctvchoose,ccheck,huati,liuyan,usersnumbers,s_pid;
	 private int currentPage=0,pageSize=5;
	 private String cname,cdate,c_pros,cdetail,pros,clogo,cimgs,ctext,cvideo,cusername,cpwd;
	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private Scores score;
	public int getUsersnumbers() {
		return usersnumbers;
	}

	public void setUsersnumbers(int usersnumbers) {
		this.usersnumbers = usersnumbers;
	}

	
//	private List<Projects> listPro=null;
	public Comps() {}

	public Comps(int c_tid, String cname, String cdate) {
		super();
		this.c_tid = c_tid;
		this.cname = cname;
		this.cdate = cdate;
	}

	public Comps(int cid, int c_tid, String cname, String cdate) {
		super();
		this.cid = cid;
		this.c_tid = c_tid;
		this.cname = cname;
		this.cdate = cdate;
	}
	
//	public List<Projects> getListPro() {
//		return listPro;
//	}
//
//	public void setListPro(List<Projects> listPro) {
//		this.listPro = listPro;
//	}
	
	public int getNumbers() {
		return numbers;
	}

	public int getS_pid() {
		return s_pid;
	}

	public void setS_pid(int s_pid) {
		this.s_pid = s_pid;
	}

	public Scores getScore() {
		return score;
	}

	public void setScore(Scores score) {
		this.score = score;
	}

	public int getHuati() {
		return huati;
	}

	public void setHuati(int huati) {
		this.huati = huati;
	}

	public int getLiuyan() {
		return liuyan;
	}

	public void setLiuyan(int liuyan) {
		this.liuyan = liuyan;
	}

	public String getCusername() {
		return cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public int getCcheck() {
		return ccheck;
	}

	public void setCcheck(int ccheck) {
		this.ccheck = ccheck;
	}

	public String getCtext() {
		return ctext;
	}

	public void setCtext(String ctext) {
		this.ctext = ctext;
	}

	public String getCvideo() {
		return cvideo;
	}

	public void setCvideo(String cvideo) {
		this.cvideo = cvideo;
	}

	public int getCtvchoose() {
		return ctvchoose;
	}

	public void setCtvchoose(int ctvchoose) {
		this.ctvchoose = ctvchoose;
	}

	public String getCimgs() {
		return cimgs;
	}

	public void setCimgs(String cimgs) {
		this.cimgs = cimgs;
	}

	public String getClogo() {
		return clogo;
	}

	public void setClogo(String clogo) {
		this.clogo = clogo;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getC_pros() {
		return c_pros;
	}

	public void setC_pros(String c_pros) {
		this.c_pros = c_pros;
	}

	public String getCdetail() {
		return cdetail;
	}

	public void setCdetail(String cdetail) {
		this.cdetail = cdetail;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getC_tid() {
		return c_tid;
	}
	public void setC_tid(int c_tid) {
		this.c_tid = c_tid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "Comps [cid=" + cid + ", c_tid=" + c_tid + ", numbers=" + numbers + ", ctvchoose=" + ctvchoose
				+ ", ccheck=" + ccheck + ", cname=" + cname + ", cdate=" + cdate + ", c_pros=" + c_pros + ", cdetail="
				+ cdetail + ", pros=" + pros + ", clogo=" + clogo + ", cimgs=" + cimgs + ", ctext=" + ctext
				+ ", cvideo=" + cvideo + ", cusername=" + cusername + "]";
	}


}
