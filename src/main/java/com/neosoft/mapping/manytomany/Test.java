package com.neosoft.mapping.manytomany;

import java.util.ArrayList;
import java.util.List;

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
		
		Laptop lap=new Laptop(121, "Dell");
		List<Student> list=new ArrayList<Student>();
		Student std=new Student(1, "Riddhi", 50);
		Student std1=new Student(2, "Siddhi", 45);
		list.add(std);
		list.add(std1);
		lap.setStudent(list);
		s.save(lap);
		tx.commit();
	}
}
