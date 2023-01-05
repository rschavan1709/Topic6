package com.neosoft.mapping.onetomany;

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
		
		/*
		 * Laptop lap=new Laptop(1011, "Dell"); Laptop lap1=new Laptop(1012,"Hp");
		 * List<Laptop> list=new ArrayList<Laptop>(); list.add(lap); list.add(lap1);
		 * Student std=new Student(1, "Riddhi", 50); std.setLaptops(list); s.save(lap);
		 * s.save(lap1); s.save(std);
		 */
		 
		Student std=new Student(1, "Riddhi", 50); 
		Laptop lap=new Laptop(1011, "Dell"); 
		
		/*
		 * Student std=new Student(1, "Riddhi", 50); s.save(std); Laptop lap=new
		 * Laptop(1011, "Dell"); Laptop lap1=new Laptop(1012,"Hp"); lap.setStudent(std);
		 * lap1.setStudent(std); s.save(lap); s.save(lap1);
		 */
		 
		 
		/*
		 * Student std1=s.get(Student.class, 1); System.out.println(std1.getName());
		 * List<Laptop> l=std1.getLaptops(); for(Laptop l1:l) { System.out.println(l1);
		 * }
		 */
		 
		tx.commit();
		s.close();
		
	}
}
