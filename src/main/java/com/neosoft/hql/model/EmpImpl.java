package com.neosoft.hql.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;
import com.neosoft.hql.pojo.Employee;

public class EmpImpl {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
	
	// to add data
	/*
	 * Employee e=new Employee(); e.setEmployeeName("Riddhi");
	 * e.setSalary(30000.00);
	 * 
	 * s.save(e);
	 */
	
	// to get for fetch data
	/*
	 * Employee e=s.get(Employee.class, 2); System.out.println(e);
	 */
	
	// to load for fetch data
	/*
	 * Employee e=s.load(Employee.class, 1); System.out.println(e);
	 */
	
	// to update
	/*
	 * Employee e=s.get(Employee.class, 1); e.setSalary(32000.00); s.update(e);
	 * System.out.println(e);
	 */
	
	// HQL Query
		
	// hql query for fetch all columns data 
	/*
	 * Query q= s.createQuery("from Employee"); List<Employee> l=q.list();
	 * System.out.println(l);
	 */
		
	// hql qery for fetch particular column data
	/*
	 * Query q=s.createQuery("Select employeeName from Employee"); List l1=q.list();
	 * System.out.println(l1);
	 */
		
	// Prepared Statement
	// to fetch data input get from user
	/*
	 * String name="Riddhi"; Query
	 * q=s.createQuery("From Employee where employeeName=:n "); q.setParameter("n",
	 * name); List<Employee> l=q.list(); System.out.println(l);
	 */
		
		// for normal sql query
		// to fetch data
		/*
		* SQLQuery q=s.createSQLQuery("Select * from employee_table");
		* q.addEntity(Employee.class); List<Employee> l=q.list();
		* System.out.println(l);
		*/
		
		// to update
		/*
		 * SQLQuery q=s.
		 * createSQLQuery("Update employee_table set employee_name=:name where employee_id=:id"
		 * ); q.addEntity(Employee.class); q.setParameter("name", "Riddhi");
		 * q.setParameter("id", 1); int i=q.executeUpdate();
		 */
		
	// to update
	/*
	 * Query q=s.
	 * createQuery("Update Employee set employeeName=:name where employeeId=:id ");
	 * q.setParameter("name", "Siddhi"); q.setParameter("id", 1); int
	 * i=q.executeUpdate();
	 */
	
	// Criteria
	// salary greater than 30000.00
	
	  Criteria c=s.createCriteria(Employee.class); 
	  c.add(Restrictions.and(Restrictions.gt("salary",30000d), Restrictions.le("salary", 40000d)));
	  List<Employee> l=c.list(); System.out.println(l);
	 
	// projection: fetch particular column
	/*
	 * Criteria c=s.createCriteria(Employee.class);
	 * c.setProjection(Projections.property("employeeId")); List l=c.list();
	 * System.out.println(l);
	 */
	
	TypedQuery q=s.getNamedQuery("byName");
	q.setParameter("name", "Riddhi");
	List<Employee>list=q.getResultList();
	System.out.println(list);
	tx.commit();
	sf.close();
	s.close();
        
	}
}
