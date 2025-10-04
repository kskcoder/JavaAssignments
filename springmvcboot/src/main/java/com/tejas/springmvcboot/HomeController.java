package com.tejas.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tejas.springmvcboot.model.Users;
@Controller
public class HomeController {
	@Autowired
	UsersRepo ur;
	
	@ModelAttribute
	public void nameUser(Model model) {
		model.addAttribute("users", "humans");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("addUser")
	public String addUser(@ModelAttribute("u") Users u) {
//		model.addAttribute("user", user);	
		ur.save(u);
		return "result";
	}
	
	@GetMapping("getAllusers")
	public String getUsers(Model m) {
		
		m.addAttribute("usersList", ur.findAll());
		
		return "showUsers";
	}
	
	@GetMapping("getUser")
	public String getUserById(@RequestParam int uid, Model m) {
		m.addAttribute("usersList", ur.getOne(uid));
		
		return "showUsers";
	}
	
	@GetMapping("getUserByName")
	public String getUserByName(@RequestParam String fname, Model m) {
		m.addAttribute("usersList", ur.getUsersByFname(fname));
		
		return "showUsers";
	}
} 
