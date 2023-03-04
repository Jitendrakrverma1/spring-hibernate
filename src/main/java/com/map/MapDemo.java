package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//		 creating question
//		Question q1 = new Question();
//		q1.setQuestionId(1211);
//		q1.setQuestion("What is Java");
//
//		// creating answer1
//		Answer answer = new Answer();
//		answer.setAnswerId(347);
//		answer.setAnswer("Java is progrmaming language..");
//		answer.setQuestion(q1);
//
//		// creating question 2
//		Question q2 = new Question();
//		q2.setQuestionId(243);
//		q2.setQuestion("What is collection framework.");
//
//		// creating answer2
//		Answer answer1 = new Answer();
//		answer1.setAnswerId(348);
//		answer1.setAnswer("API is an object...");
//		answer1.setQuestion(q1);
//
//		// creating answer3
//		Answer answer3 = new Answer();
//		answer3.setAnswerId(349);
//		answer3.setAnswer("Java has different type of framework..");
//		answer3.setQuestion(q1);
////		
//		List<Answer> list = new ArrayList<Answer>();
//		list.add(answer);
//		list.add(answer1);
//		list.add(answer3);
////
//		q1.setAnswers(list);
		
		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save  (oneToOne and OneToMany)
//		session.save(q1);
//		session.save(q2);
//		session.save(answer);
//		session.save(answer1);
//		session.save(answer3);
//		tx.commit();

		// fetching  (oneToOne)
//
////		Question n1 = (Question) session.get(Question.class, 242);
////		System.out.println(n1.getQuestion());
////		System.out.println(n1.getAnswer().getAnswer());

		// fetching (oneToMany)
//		Question q = (Question)session.get(Question.class, 1212);
//		System.out.println(q.getQuestion());
//		for (Answer a : q.getAnswers())
//		{
//		   System.out.println(a.getAnswer());   
//		}
		
		
		// fetch type (Lazy and eager)
//		
//		Question q = (Question)session.get(Question.class, 1211);
//		System.out.println(q.getQuestionId());
//		System.out.println(q.getQuestion());
////		
//		// lazy
//		System.out.println(q.getAnswers().size());
		
       tx.commit();
		
		session.close();
		factory.close();

	}
}
