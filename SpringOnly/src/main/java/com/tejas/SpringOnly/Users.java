package com.tejas.SpringOnly;


public class Users {
	private int uid;
	private String fname;
	private String lname;
	private Account account;
	
	
	
	public Users(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

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
	
	public void returnAction() {
		System.out.println("Hello Chulna!");
		account.printType();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
