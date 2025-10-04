package com.tejas.JPAExample;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	Account a = new Account();
    	
    	a.setAid(102);
    	a.setType("current");
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	em.persist(a);
    	
    	em.getTransaction().commit();
    	
    	em.close();
    }
}
