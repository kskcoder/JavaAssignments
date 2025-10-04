package com.tejas.SpringOnly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring.xml");
        Users u = (Users)bf.getBean("user");
        u.returnAction();
        System.out.println(u.getUid()) ;
    } 
}
