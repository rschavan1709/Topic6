package com.neosoft.mapping.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> student;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	
}
