package com.tut;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FetchDemo 
{
	public static void main(String[] args) 
	{
	  //get , load()
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
//		 load - Student
        Student student = session.load(Student.class, 101);
		System.out.println(student);
		
		  // get
		
//		Address ad = session.get(Address.class, 2);
//		System.out.println(ad.getStreet()+" : "+ad.getCity());
//		
//		Address ad1 = session.get(Address.class, 2);
//		System.out.println(ad1.getStreet()+" : "+ad1.getCity());
		
		
		
		
		session.close();
		factory.close();
		
		
	}
}
