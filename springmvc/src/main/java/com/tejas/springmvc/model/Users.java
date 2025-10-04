package com.tejas.springmvc.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users_table1")
public class Users {
	
	@Id
	@Column(name="uid")
	private int userId;
	
	private String fname;
	private String lname;


	public int getUid() {
		return userId;
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

	public void setUid(int uid) {
		this.userId = uid;
	}

	public String toString() {
		return "Users [userid=" + userId + ", fname=" + fname + ", lname=" + lname + "]";
	}
}
