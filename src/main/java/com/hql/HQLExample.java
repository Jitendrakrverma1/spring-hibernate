package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample 
{
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
        // HQL :- query that apply on class
		// Syntax
		//
//		String query = "from Student";
//		String query = "from Student where city='Kanpur'";
//		String query = "from Student where city=:x";
		String query = "from Student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		
		q.setParameter("x", "Kanpur");
		q.setParameter("n", "Mahesh");
		// single -> unique
		// multiple -> list
		List<Student> list = q.list();
		for(Student s1: list)
		{
			System.out.println(s1.getName()+" : "+s1.getCerti().getCourse());
		}
		
		Transaction tx = s.beginTransaction();
		System.out.println("-----------------------------------------");
		
		// delete query
//		Query q2 = s.createQuery("delete from Student  s where city=:c");
//		q2.setParameter("c", "Kanpur");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted:----");
//		System.out.println(r);
		
		// update Query
//		Query q2 = s.createQuery("update Student set city=:c where name=:n");
//		q2.setParameter("c", "Ayodhya1");
//		q2.setParameter("n", "Anoop");
//		int r = q2.executeUpdate();
//		System.out.println(r+ " Objects updated");
		
		//join query
//		Query q2 = s.createQuery("select q.question , q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
//		List<Object[]> list1 = q2.getResultList();
//		for(Object[] arr: list1)
//		{
//			System.out.println(Arrays.toString(arr));
//		}
		tx.commit();
		s.close();
		factory.close();
	}
}
