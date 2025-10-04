package com.tejas.DemoHib;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="users_table1")
public class Users {
	
	@Id()
	 private int uid;
	
	 private Uname name;
	
	@Transient()
	 private int age;
	
	@ManyToMany(mappedBy="users", fetch=FetchType.LAZY)
	private List<Account> accounts = new ArrayList<>();
	 
	 public int getUid() {
		 return uid;
	 }
	 public List<Account> getAccounts() {
		return accounts;
	}
	 public void setAccounts(List<Account> accounts) {
		 this.accounts = accounts;
	 }
	 public void setUid(int uid) {
		 this.uid = uid;
	 }
	 public Uname getName() {
		 return name;
	 }
	 public void setName(Uname name) {
		 this.name = name;
	 }
	 public int getAge() {
		 return age;
	 }
	 public void setAge(int age) {
		 this.age = age;
	 }
	
}
