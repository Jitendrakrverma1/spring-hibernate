package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws Exception 
	{
		System.out.println("Project started.......");
       // SessionFactory factory = (SessionFactory) new Configuration().configure().buildSessionFactory();
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// creating student
		Student st = new Student();
		st.setId(103);
		st.setName("Jack1");
		st.setCity("Ayodhya2");
		System.out.println(st);
		
		//creating object of address class
		Address ad = new Address();
		ad.setStreet("street3");
		ad.setCity("DElHI2");
		ad.setOpen(true);
//		ad.setAddedDate( new Date());
		ad.setX(123.232);
		
//		reading images
		FileInputStream fis = new FileInputStream("src/main/java/pic.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		
		 Session session = factory.openSession();	
		 Transaction tx = session.beginTransaction();
		 session.save(st);
		 session.save(ad);
		 tx.commit();
		 session.close();
		 System.out.println("Done");
	
		
	}
}
//		System.out.println(factory);
//		System.out.println(factory.isClosed());
