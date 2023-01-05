package com.neosoft.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	@ManyToOne()
	@JoinColumn(name = "sid")
	private Student student;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	
}
