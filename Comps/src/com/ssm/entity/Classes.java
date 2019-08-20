package com.ssm.entity;

import java.util.List;

public class Classes {
	private int clid;
	private String clname,cltest;
	private List<Student> students; 
	public Classes() {}
	public Classes(int clid, String clname, String cltest) {
		super();
		this.clid = clid;
		this.clname = clname;
		this.cltest = cltest;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getCltest() {
		return cltest;
	}
	public void setCltest(String cltest) {
		this.cltest = cltest;
	}
	@Override
	public String toString() {
		return "Classes [clid=" + clid + ", clname=" + clname + ", cltest=" + cltest + "]";
	}
	
}
