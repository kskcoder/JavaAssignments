package com.tejas.HibernateHQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings({ "unchecked", "deprecation" })
	public static void main( String[] args )
    {    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Users.class);
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(sr);    	
    	
    	int a = 2;
    	
    	//HQL queries
    	String fetchStudent = "from Users where uid < :a";    	    	
    	
    	Session session1 = sf.openSession();
    	session1.getTransaction().begin();
    	
    	Query q1 = session1.createQuery(fetchStudent);
    	q1.setParameter("a", a);
    	
    	Users user = (Users)q1.uniqueResult(); 
    	System.out.println(user);
    	
    	//Native SQL query
    	
//    	NativeQuery query = session1.createNativeQuery("select uid, fname, lname from users_table1");
    	
    	
    	
    	List<Users> users = session1.createNativeQuery(
    	        "select uid, fname, lname from users_table1", Users.class
    	    ).list();

    	
    	for (Users u: users) {
    		System.out.println(u);
    	}
    	
    	List<Object[]> rows = session1.createNativeQuery(
    	        "select uid, fname from users_table1"
    	    )
    	    .list();

    	for (Object[] row : rows) {
    	    Integer uid = ((Number) row[0]).intValue();
    	    String fname = (String) row[1];
    	    System.out.println(uid + " - " + fname);
    	}
    	
    	session1.getTransaction().commit();
    	session1.close();
    	
    	sf.close();
    }
}
