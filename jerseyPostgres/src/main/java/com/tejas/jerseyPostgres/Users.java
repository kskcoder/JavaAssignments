package com.tejas.jerseyPostgres;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {
	private int uid;
	private String name;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", name=" + name + "]";
	}
}
