package com.tejas.newDemoREST;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
	List<Users> users = new ArrayList<>();
	
	public UsersRepository() {
		Users u = new Users();
		u.setUid(1);
		u.setName("Tejas");
		
		Users u1 = new Users();
		u1.setUid(2);
		u1.setName("Jejas");
		
		users.add(u);
		users.add(u1);
	}
	
	public List<Users> getUsers() {
		return users;
	}
	
	public Users getUser(int uid) {
		return users.stream().filter(n -> n.getUid() == uid).findFirst().orElse(null);
	}	
	
	public void addUser(Users user) {
		users.add(user);
		
		System.out.println(user);
		return;
	}
}
