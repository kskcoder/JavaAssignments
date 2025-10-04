package com.tejas.SpringJDBC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Users {
	private int userid;
	private String fname;
	private String lname;


	public int getUserid() {
		return userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String toString() {
		return "Users [userid=" + userid + ", fname=" + fname + ", lname=" + lname + "]";
	}
}
