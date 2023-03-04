package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args)
	{
		// Practical of Hibernate Object states
		//Transient
		// Persistent
		//Dtacted
		//Removed
		System.out.println("Example:----");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory f = cfg.buildSessionFactory();
		
		
		// creating student object
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("Kanpur");
		student.setCerti(new Certificate("Java HIbernate Course","2 month"));
		// student : Transient
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		
		// student : Perisistent - session,database
		student.setName("Mahesh");
		tx.commit();
		
		s.close();
		
		// student :- Detached
		student.setName("Sachin");
		System.out.println(student);
		
		f.close();
	}

}
