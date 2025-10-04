package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootRestApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(SpringbootRestApplication.class, args);
		
		ForBeanClass fbc = con.getBean(ForBeanClass.class);
		
		fbc.returnAction();
	}
}
