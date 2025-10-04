package com.tejas.DemoHib;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */ 
public class App 
{
    public static void main( String[] args )
    {
    	Account ac = new Account();
    	ac.setAid(101);
    	ac.setType("savings");
    	
    	
    	Users user = new Users();
    	user.setUid(3);
    	
    	Uname name = new Uname();
    	name.setfName("Tejas");
    	name.setlName("Kashid");
    	
    	user.setName(name);
    	user.setAge(23);
    	
    	user.getAccounts().add(ac);
    	
    	ac.getUsers().add(user);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Users.class).addAnnotatedClass(Account.class);
    	
    	ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory(sr);
    	
    	Session session = sf.openSession(); 
    	
    	

    	
    	session.getTransaction().begin();
    	    			
//    	session.persist(ac);
//    	session.persist(user);
    	
    	Users u1 = (Users)session.find(Users.class, 3);
    	System.out.println(u1);
//    	
    	Collection<Account> acs = u1.getAccounts();
    	for (Account ac1: acs) {
    		System.out.println(ac1);
    	}

    	
    	session.getTransaction().commit();
   
    	
    	
    }
}
