package com.pagination;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class PaginationDemo 
{
	public static void main(String[] args) 
	{
	  SessionFactory factory = new Configuration().configure().buildSessionFactory();
	  Session s = factory.openSession();
	  
	   Query<Student> query = s.createQuery("from Student");
	  
	   // implementing pegination using hibernate
	   
	   query.setFirstResult(4);
	   
	   query.setMaxResults(3);
	   
	   List<Student> list = query.list();
	   for(Student st : list) {
		   System.out.println(st.getId()+": "+st.getName()+" : "+st.getCity());
	   }
	   
	  s.close();
	  factory.close();
	}
}
