package com.tejas.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.SpringJDBC.Repository.UserRepo;
import com.tejas.SpringJDBC.model.Users;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Users user = context.getBean(Users.class);
		user.setUserid(4);
		user.setFname("Tejas");
		user.setLname("Kashid");
		
		UserRepo ur = context.getBean(UserRepo.class);
		ur.save(user);
		
		System.out.println(ur.findAll());
	}

}
