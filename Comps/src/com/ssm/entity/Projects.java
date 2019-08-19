package com.ssm.entity;

public class Projects {
    private int pid,numbers;
    private String pname,pdetail,ptest,plogo;
    
	public Projects() {
		// TODO Auto-generated constructor stub
	}
    
	public String getPlogo() {
		return plogo;
	}

	public void setPlogo(String plogo) {
		this.plogo = plogo;
	}

	public String getPtest() {
		return ptest;
	}

	public void setPtest(String ptest) {
		this.ptest = ptest;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
    
}
