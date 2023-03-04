package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// first student
		Student student1 = new Student();
		student1.setId(14134);
		student1.setName("Ankit Towari");
		student1.setCity("Allahabad");
		
		// first student certificate
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		student1.setCerti(certificate);
		
		// second student
		Student student2 = new Student();
		student2.setId(1212);
		student2.setName("Ravi Towari");
		student2.setCity("ahemdf");
		
		//second student certificate
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5months");
		student2.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		//object save
		s.save(student1);
		s.save(student2);
		
		
		tx.commit();
		s.close();
		factory.close();
	}

}
