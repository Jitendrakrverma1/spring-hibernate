package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.tut.Student;

public class Secondcache 
{
	public static void main(String[] args) 
	{
		SessionFactory  factory = 	new Configuration().configure().buildSessionFactory();
	    Session s = factory.openSession();
	    // first
	    Student student1 = s.get(Student.class, 12);
	    System.out.println(student1);
	    s.close();
	    
	    Session s1 = factory.openSession();
	    // second
	    Student student2 = s.get(Student.class, 12);
	    System.out.println(student2);
	    s1.close();
	}

}
