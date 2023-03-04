package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	public static void main(String[] args) 
	{
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session s = factory.openSession();	
		 Criteria c  = s.createCriteria(Student.class);
		 
		 c.add(Restrictions.eq("certi.course", "Android"));
		 
		 List<Student> s1 = c.list();
		for(Student s3: s1)
		{
			System.out.println(s3);
		}
		 s.close();

	}

}
