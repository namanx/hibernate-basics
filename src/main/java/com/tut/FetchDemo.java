package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {
	
	public static void main(String [] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		org.hibernate.Session session = factory.openSession();
		// get student
		
//		Address student =(Address)session.get(Address.class, 1);
		Student student = (Student)session.get(Student.class,108);
		System.out.println(student);
		session.close();
		factory.close();
	}

}
