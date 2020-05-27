package com.athiya.hybernatequerylanguage;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration con=new Configuration().configure("hybernate.cfg.xml").addAnnotatedClass(Stud.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        
        
        //to get collection of records
        Query q=session.createQuery(" from Stud where marks>50");//entity name should be place here
        List<Stud> student=q.list();
        
        for(Stud std:student) {
        	System.out.println(std);
        }
        
        
        //to get single record
        
        Query q1=session.createQuery(" from Stud where id=5");//entity name should be place here
       Stud student1=(Stud) q1.uniqueResult();
        
       
        	System.out.println(student1);
      
		/*
		 * Random r=new Random();
		 * 
		 * for(int i = 0;i<50;i++) { Stud s=new Stud(); s.setId(i); s.setName("athiya");
		 * s.setMarks(r.nextInt(100)); session.save(s); }
		 */
        
        tx.commit();
    }
}
