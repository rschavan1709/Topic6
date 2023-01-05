package com.neosoft.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javassist.tools.reflect.Sample;

public class Test {
public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query q1= s.createQuery("from Student where id=1");
		q1.setCacheable(true);
		Student std1=(Student) q1.uniqueResult();
		System.out.println(std1);
		Query q2=s.createQuery("update Student set marks=100 where id=1");
		q2.setCacheable(true);
		int i=q2.executeUpdate();
		tx.commit();
		q1=s.createQuery("from Student where id=1");
		q1.setCacheable(true);
		Student std3=(Student) q1.uniqueResult();
		System.out.println(std3);
		s.close();
		
		/*
		 * Session s1=sf.openSession(); Transaction tx1=s1.beginTransaction(); Query q2=
		 * s1.createQuery("from Student where id=1"); q2.setCacheable(true); Student
		 * std2=(Student) q2.uniqueResult(); System.out.println(std2); tx1.commit();
		 * s1.close();
		 */
		
	}

}
