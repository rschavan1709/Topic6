package com.neosoft.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		Student std=new Student(1, "Riddhi", 50);
		Laptop lap=new Laptop(121, "Dell");
		
		s.save(std);
		s.save(lap);
		
		tx.commit();
	}
}
