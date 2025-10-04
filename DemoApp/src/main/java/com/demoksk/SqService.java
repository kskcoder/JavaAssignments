package com.demoksk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqService extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		Cookie cookie[] = req.getCookies();
		
		int sum = 0;
		
		for (Cookie c: cookie) {
			if (c.getName().equals("sum")) 
				sum = Integer.parseInt(c.getValue());
		}
		
		PrintWriter pw = res.getWriter();
		pw.println(sum*sum);	
	}
}
   