package com.tejas.JPAExample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Account {
	@Id
	private int aid;
	private String type;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", type=" + type + "]";
	}
}
