package com.tejas.HibCache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tejas.HibCache.Uname;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Users user = new Users();
    	Uname name = new Uname();
    	name.setfName("Tejas");
    	name.setlName("Kashid");
    	
    	user.setUid(1);
    	user.setName(name);
    	user.setAge(23);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Users.class);
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(sr);
    	
    	Session session1 = sf.openSession();
    	String fetchStudent = "from Users where uid = 3";
    	    	
    	Query q1 = session1.createQuery(fetchStudent);
    	q1.setCacheable(true);
    	session1.getTransaction().begin();
    	
    	Users u1 = (Users)q1.uniqueResult();
    	
    	session1.getTransaction().commit();
    	session1.close();
    	
    	Session s2 = sf.openSession();

    	Query q2 = s2.createQuery(fetchStudent);
    	q2.setCacheable(true);
    	s2.getTransaction().begin();
    	
    	Users u2 = (Users)q2.uniqueResult();
    	
    	s2.getTransaction().commit();
    	s2.close();
    	
    	sf.close();
    }
 
}
