package com.tejas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	UsersRepository ur;
	
	@GetMapping("users")
	public List<Users> getUsers() {
		List<Users> users = (List<Users>) ur.findAll();
				
		return users;
	}
}
