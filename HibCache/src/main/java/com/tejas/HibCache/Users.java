package com.tejas.HibCache;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="users_table1")
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Users {
	
	@Id()
	 private int uid;
	
	@Embedded
	 private Uname name;
	
	@Transient()
	 private int age;
	
	 public int getUid() {
		 return uid;
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
