package com.tejas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="users_table1")
public class Users {
	
	@Id
	private int uid;
	private String fname;
	private String lname;
	
	
	public int getUid() {
		return uid;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", fname=" + fname + ", lname=" + lname + "]";
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
		this.uid = uid;
	}


}
