package com.tejas.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tejas.springmvc.dao.UserDao;
import com.tejas.springmvc.model.Users;
@Controller
public class HomeController {
	@Autowired
	private UserDao userdao;
	
	@ModelAttribute
	public void nameUser(Model model) {
		model.addAttribute("users", "humans");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("add")
	public String add(@RequestParam int num1, @RequestParam int num2, ModelMap m) {
		int sum = num1 + num2;
		
		m.addAttribute("ans", sum);
		
		return "result";
	}
	
	@GetMapping("addUser")
	public String addUser(@ModelAttribute("u") Users u) {
//		model.addAttribute("user", user);	
		userdao.addUser(u);
		return "result";
	}
	
	@GetMapping("users")
	public String getUsers(Model m) {
		
		m.addAttribute("usersList", userdao.getUsers());
		
		return "showUsers";
	}
	
	@GetMapping("getUser")
	public String getUserById(@RequestParam("uuid") int uid, Model m) {
		m.addAttribute("usersList", userdao.getUserById(uid));
		
		return "showUsers";
	}
} 
