package com.tejas.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.springmvcboot.model.Users;

@RestController
public class UserController {
	
	@Autowired
	UsersRepo ur;

	@GetMapping("users")
	public List<Users> getUsers() {
		List<Users> users = ur.findAll();
		
		return users ;
	}
	
	@GetMapping("user/{id}")
	public Users getUserById(@PathVariable("id") int uid) {
		return ur.findById(uid).orElse(new Users(uid, "", ""));
	}
	
	@PostMapping(path="user", consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Users addUser(@RequestBody Users user) {
		ur.save(user);
		return user;
	}
}
