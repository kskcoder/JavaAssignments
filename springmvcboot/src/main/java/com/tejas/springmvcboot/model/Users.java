package com.tejas.springmvcboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users_table1")
public class Users {
		
	@Column(name="uid")
	@Id
	private Integer userid;
	private String fname;
	private String lname;

	public Users() {}
	
	public Users(int userid, String fname, String lname) {
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
	}
	
	public int getUid() {
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

	public void setUid(int userid) {
		this.userid = userid;
	}

	public String toString() {
		return "Users [userid=" + userid + ", fname=" + fname + ", lname=" + lname + "]";
	}
}
