package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstCache 
{
	public static void main(String[] args)
	{
		SessionFactory  factory = 	new Configuration().configure().buildSessionFactory();
	    Session s = factory.openSession();
	    
	    // by default enabled
	    Student student  = s.get(Student.class, 12);
	    System.out.println(student);
	    System.out.println("Working something.....");
	     Student student1 = s.get(Student.class, 12);
	     System.out.println(student1);
	     System.out.println(s.contains(student1));
	     s.close();
	     
	}
}
